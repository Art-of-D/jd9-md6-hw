package org.utils;

import org.db.Database;
import org.selection_classes.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
   private static final String URL_UNIT_DB= String.valueOf("jdbc:h2:"+ Paths.get("db"));

    //- додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта
    long create(String name) throws Exception {
        String statement = "INSERT INTO client(name) VALUES ('" + name + "');";
        new FileCreator(VersionHolder.version, statement);
        try (Connection connection = new Database().getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, name);
            insertStmt.executeUpdate();
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }
        }
    }

    //- повертає назву клієнта з ідентифікатором id
    String getById(long id) throws SQLException, Exception {
        String getById = "SELECT * FROM client WHERE id = (?)";
        int sqlId = (int) id;
        try( Connection cnct = new Database().getConnection();
            PreparedStatement stmt = cnct.prepareStatement(getById)){
            stmt.setInt(1, sqlId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                } else {
                    throw new Exception("No client found with ID " + sqlId);
                }
        }
        } catch (SQLException ex) {
            throw new Exception("Error retrieving client with ID " + sqlId, ex);
        }
    }

    //- встановлює нове ім'я name для клієнта з ідентифікатором id
    void setName(long id, String name) throws IOException {
        int setId = (int) id;
        String statement = "UPDATE client SET name = '" + name + "' WHERE id = " + setId + ";";
        new FileCreator(VersionHolder.version, statement);
    }

    //- видаляє клієнта з ідентифікатором id
    void deleteById(long id) throws IOException {
        String statement = "DELETE FROM client WHERE id = " + id + ";";
        new FileCreator(VersionHolder.version, statement);
    }

    //- повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client
    // (цей клас створи сам, у ньому має бути 2 поля - id та name)
    List<Client> listAll() throws SQLException, IOException {
        String str = "SELECT * FROM client";
        List<Client> list = new ArrayList<>();
        Connection data = new Database().getInstance().getConnection();
        PreparedStatement statement = data.prepareStatement(str);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            list.add(new Client(id, name));
        }
        return list;
    }
}
