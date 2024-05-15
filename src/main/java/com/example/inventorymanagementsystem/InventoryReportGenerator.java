package com.example.inventorymanagementsystem;

import java.sql.*;

public class InventoryReportGenerator {
    public static void main(String[] args) {
        // Устанавливаем соединение с базой данных
        try {
            // Устанавливаем соединение с базой данных MySQL
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "123456789sql");

            // Создаем объект для выполнения SQL-запросов
            Statement statement = connection.createStatement();

            // Выполняем SQL-запрос для выборки данных о товарах из таблицы inventory
            ResultSet resultSet = statement.executeQuery("SELECT name, quantity FROM inventory");

            // Перебираем результаты запроса и выводим информацию о товарах
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                System.out.println("Item: " + name + ", Quantity: " + quantity);
            }

            // Закрываем результаты запроса, оператор SQL и соединение с базой данных
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // Обрабатываем возможные ошибки соединения или выполнения SQL-запроса
            e.printStackTrace();
        }
    }
}
