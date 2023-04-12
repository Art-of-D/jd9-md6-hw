package org.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private static final String BASE_PART_URL = "jdbc:h2:" +
            Paths.get("db").toAbsolutePath();
    private Connection cnct;
    private static Database instance;

    private String name = "";
    private String password = "";


    public static Database getInstance() {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            this.cnct = DriverManager.getConnection(BASE_PART_URL,
                    String.valueOf(settings().get("account")),
                    String.valueOf(settings().get("password")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnct;
    }

    private Map settings(){
        String FILENAME = "src/main/resources/connection_settings.json";
        Map<String, String> map = new HashMap<>();
        try {
            String string = Files.readAllLines(Paths.get(FILENAME)
                    .toAbsolutePath())
                    .stream()
                    .collect(Collectors.joining("\n"));
            TypeToken<?> ttoken = TypeToken.getParameterized(Map.class, String.class, String.class);
            map = new Gson().fromJson(string, ttoken.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
