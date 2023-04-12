package org.main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.flywaydb.core.Flyway;
import org.utils.Choice;
import org.utils.VersionHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.migration();
        try{
            new Choice().giveChoice();
            main.migration();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void migration(){
        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:file:./db",
                        String.valueOf(new Main().settings().get("account")),
                        String.valueOf(new Main().settings().get("password")))
                .table("flyway_schema_history")
                .locations("flyway_sql")
                .load();
        flyway.migrate();
        new VersionHolder(Integer.parseInt(String.valueOf(flyway.info().current().getVersion())));

    }
    private Map settings(){
        String FILENAME = "src/main/resources/connection_settings.json";
        Map<String, String> map = new HashMap<>();
        try {
            String string = Files.readAllLines(Paths.get(FILENAME).toAbsolutePath()).stream().collect(Collectors.joining("\n"));
            TypeToken<?> ttoken = TypeToken.getParameterized(Map.class, String.class, String.class);
            map = new Gson().fromJson(string, ttoken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}