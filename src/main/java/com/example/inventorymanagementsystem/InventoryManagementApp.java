package com.example.inventorymanagementsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryManagementApp extends Application {
    private InventoryManager manager = new InventoryManager();
    private Inventory inventory;

    @Override
    public void start(Stage primaryStage) {
        // Инициализация инвентаря
        inventory = new Inventory();

        // Создание кнопок для операций с инвентарем
        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> {
            String name = DialogManager.showTextInputDialog("Add Item", null, "Enter item name:");
            if (name != null && !name.isEmpty()) {
                manager.addItem(name, 1); // Добавление товара с начальным количеством 1
                updateItemList();
            }
        });

        Button removeItemButton = new Button("Remove Item");
        removeItemButton.setOnAction(e -> {
            String name = DialogManager.showTextInputDialog("Remove Item", null, "Enter item name:");
            if (name != null && !name.isEmpty()) {
                manager.removeItem(name);
                updateItemList();
            }
        });

        // Создание макета для размещения кнопок
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(addItemButton, removeItemButton);

        // Создание сцены и установка на ней макета
        Scene scene = new Scene(layout, 300, 200);

        // Установка сцены на основную сцену приложения
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Management App");
        primaryStage.show();
    }

    private void updateItemList() {
        // Обновление списка элементов инвентаря
        // Например, получение данных из менеджера инвентаря и обновление интерфейса
    }

    public static void main(String[] args) {
        launch(args);
    }
}
