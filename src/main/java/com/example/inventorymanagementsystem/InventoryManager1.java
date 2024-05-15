package com.example.inventorymanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager1 {
    private Map<String, InventoryItem> inventory;

    public InventoryManager1() {
        this.inventory = new HashMap<>();
    }

    // Добавление товара на склад (учет поступлений)
    public void addStock(String name, int quantity) {
        addItem(name, quantity);
    }
    // Добавление товара в инвентарь
    public void addItem(String name, int quantity) {
        if (inventory.containsKey(name)) {
            InventoryItem existingItem = inventory.get(name);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            inventory.put(name, new InventoryItem(name, quantity));
        }
    }

    // Продажа товара (учет расходов)
    public void sellStock(String name, int quantity) {
        if (inventory.containsKey(name)) {
            InventoryItem existingItem = inventory.get(name);
            int remainingQuantity = existingItem.getQuantity() - quantity;
            if (remainingQuantity >= 0) {
                existingItem.setQuantity(remainingQuantity);
            } else {
                System.out.println("Not enough stock available for " + name);
            }
        } else {
            System.out.println("Item not found in inventory: " + name);
        }
    }

    // Проверка доступного запаса товара
    public boolean checkStockAvailability(String name, int requiredQuantity) {
        if (inventory.containsKey(name)) {
            InventoryItem existingItem = inventory.get(name);
            int availableQuantity = existingItem.getQuantity();
            return availableQuantity >= requiredQuantity;
        } else {
            System.out.println("Item not found in inventory: " + name);
            return false;
        }
    }

    // Уведомление о нехватке товаров и автоматический заказ новых товаров
    public void notifyLowStock(String name, int threshold) {
        if (inventory.containsKey(name)) {
            InventoryItem existingItem = inventory.get(name);
            int availableQuantity = existingItem.getQuantity();
            if (availableQuantity < threshold) {
                System.out.println("Low stock for item: " + name);
                // Здесь можно реализовать автоматический заказ новых товаров
                // orderNewItems(name, quantity); // Пример заказа новых товаров
            }
        } else {
            System.out.println("Item not found in inventory: " + name);
        }
    }

    // Генерация отчета о наличии товаров определенного типа
    public void generateTypeReport(String type) {
        System.out.println("Inventory Report for type: " + type);
        int totalQuantity = 0;
        for (InventoryItem item : inventory.values()) {
            if (item.getType().equals(type)) {
                System.out.println(item.getName() + ": " + item.getQuantity());
                totalQuantity += item.getQuantity();
            }
        }
        System.out.println("Total quantity of " + type + ": " + totalQuantity);
    }

    // Генерация общего отчета о наличии всех товаров
    public void generateTotalReport() {
        System.out.println("Total Inventory Report:");
        int totalItems = 0;
        int totalQuantity = 0;
        for (InventoryItem item : inventory.values()) {
            System.out.println(item.getName() + ": " + item.getQuantity());
            totalItems++;
            totalQuantity += item.getQuantity();
        }
        System.out.println("Total items: " + totalItems);
        System.out.println("Total quantity: " + totalQuantity);
    }

    // Дополнительные методы, если необходимо
}
