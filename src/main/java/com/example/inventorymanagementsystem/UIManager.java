package com.example.inventorymanagementsystem;

import java.util.Scanner;

public class UIManager {
    private InventoryManager1 manager;
    private Scanner scanner;

    public UIManager(InventoryManager1 manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    public void showMainMenu() {
        // реализация основного меню приложения
    }

    // другие методы для отображения различных меню и взаимодействия с пользователем
}
