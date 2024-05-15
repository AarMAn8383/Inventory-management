package com.example.inventorymanagementsystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryManagementGUI extends Application {
    private InventoryManager manager = new InventoryManager();
    private ObservableList<InventoryItem> itemList = FXCollections.observableArrayList();

    private void updateItemList() {
        itemList.clear();
        itemList.addAll(manager.getInventory().values());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        // Создание таблицы для отображения инвентаря
        TableView<InventoryItem> table = new TableView<>();
        TableColumn<InventoryItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<InventoryItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table.getColumns().addAll(nameColumn, quantityColumn);
        table.setItems(itemList);

        // Поля ввода для имени и количества товара
        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(200);

        TextField quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        // Кнопки для добавления и удаления товара
        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            String quantityStr = quantityInput.getText();
            if (name != null && !name.isEmpty() && quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    manager.addItem(name, quantity);
                    updateItemList();
                    nameInput.clear();
                    quantityInput.clear();
                } catch (NumberFormatException ex) {
                    DialogManager.showErrorDialog("Invalid quantity! Please enter a valid number.");
                }
            }
        });

        Button deleteButton = new Button("Remove Item");
        deleteButton.setOnAction(e -> {
            showRemoveItemDialog();
        });

        // Кнопки для других функций
        Button addStockButton = new Button("Add Stock");
        addStockButton.setOnAction(e -> {
            String name = nameInput.getText();
            String quantityStr = quantityInput.getText();
            if (name != null && !name.isEmpty() && quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    manager.addStock(name, quantity);
                    updateItemList();
                    nameInput.clear();
                    quantityInput.clear();
                } catch (NumberFormatException ex) {
                    DialogManager.showErrorDialog("Invalid quantity! Please enter a valid number.");
                }
            }
        });

        Button sellStockButton = new Button("Sell Stock");
        sellStockButton.setOnAction(e -> {
            String name = nameInput.getText();
            String quantityStr = quantityInput.getText();
            if (name != null && !name.isEmpty() && quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    manager.sellStock(name, quantity);
                    updateItemList();
                    nameInput.clear();
                    quantityInput.clear();
                } catch (NumberFormatException ex) {
                    DialogManager.showErrorDialog("Invalid quantity! Please enter a valid number.");
                }
            }
        });

        Button checkStockButton = new Button("Check Stock");
        checkStockButton.setOnAction(e -> {
            String name = nameInput.getText();
            String quantityStr = quantityInput.getText();
            if (name != null && !name.isEmpty() && quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int requiredQuantity = Integer.parseInt(quantityStr);
                    boolean available = manager.checkStockAvailability(name, requiredQuantity);
                    if (available) {
                        DialogManager.showInfoDialog("Stock Available", "There is enough stock of " + name + " available.");
                    } else {
                        DialogManager.showInfoDialog("Stock Not Available", "There is not enough stock of " + name + " available.");
                    }
                    nameInput.clear();
                    quantityInput.clear();
                } catch (NumberFormatException ex) {
                    DialogManager.showErrorDialog("Invalid quantity! Please enter a valid number.");
                }
            }
        });

        Button generateTypeReportButton = new Button("Generate Type Report");
        generateTypeReportButton.setOnAction(e -> {
            String type = nameInput.getText();
            if (type != null && !type.isEmpty()) {
                manager.generateTypeReport(type);
                nameInput.clear();
                quantityInput.clear();
            }
        });

        Button generateTotalReportButton = new Button("Generate Total Report");
        generateTotalReportButton.setOnAction(e -> {
            manager.generateTotalReport();
        });

        // Layout для ввода данных
        HBox inputLayout = new HBox(10);
        inputLayout.setPadding(new Insets(10, 10, 10, 10));
        inputLayout.getChildren().addAll(nameInput, quantityInput, addButton, deleteButton,
                addStockButton, sellStockButton, checkStockButton,
                generateTypeReportButton, generateTotalReportButton);

        // Основной layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(table, inputLayout);

        Scene scene = new Scene(mainLayout, 1200, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm()); // Подключение CSS файла
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showRemoveItemDialog() {
        String name = DialogManager.showTextInputDialog("Remove Item", null, "Enter item name:");
        if (name != null && !name.isEmpty()) {
            manager.removeItem(name);
            updateItemList();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

