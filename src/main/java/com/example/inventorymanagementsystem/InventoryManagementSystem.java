package com.example.inventorymanagementsystem;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager1 manager = new InventoryManager1();
        UIManager uiManager = new UIManager(manager, scanner);
        uiManager.showMainMenu();
    }
}
