package com.example.inventorymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryManagementController {

    @FXML
    private TableView<InventoryItem> itemTable;

    @FXML
    private TableColumn<InventoryItem, String> nameColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> quantityColumn;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField quantityInput;

    private InventoryManager manager = new InventoryManager();
    private ObservableList<InventoryItem> itemList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        itemTable.setItems(itemList);
    }

    @FXML
    public void addItem() {
        // Добавить товар
    }

    @FXML
    public void removeItem() {
        // Удалить товар
    }

    @FXML
    public void addStock() {
        // Добавить товар на склад
    }

    @FXML
    public void sellStock() {
        // Продать товар
    }

    @FXML
    public void checkStock() {
        // Проверить запасы товара
    }

    @FXML
    public void notifyLowStock() {
        // Уведомить о низких запасах
    }

    @FXML
    public void generateTypeReport() {
        // Сгенерировать отчет о типе товара
    }

    @FXML
    public void generateTotalReport() {
        // Сгенерировать общий отчет
    }
}
