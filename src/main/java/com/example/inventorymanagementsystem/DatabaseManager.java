package com.example.inventorymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "123456789sql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewItem(String name, int quantity) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO inventory (name, quantity) VALUES ('" + name + "', " + quantity + ")";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(String name) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM inventory WHERE name = '" + name + "'";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
