package org.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileCreator {
    File file;

    public FileCreator(int version, String statement) throws IOException {
        createFile(version);
        write(statement);
    }

    private void createFile(int version) throws IOException {
        file = new File(Paths.get("src/main/resources/flyway_sql").toAbsolutePath() + "/V" + version + "__new_client.sql");
        file.createNewFile();
    }
    private void write(String statement) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(statement);
        writer.close();
    }
}
