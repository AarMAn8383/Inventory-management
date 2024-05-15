package com.example.inventorymanagementsystem;

public class InventoryUpdater implements Runnable {
    private Inventory inventory;

    public InventoryUpdater(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        // Логика обновления данных об инвентаре в фоновом режиме
    }
}
