package com.example.inventorymanagementsystem;

public interface InventoryOperation {
    void processOperation();
}

class InventoryOutflow implements InventoryOperation {
    @Override
    public void processOperation() {
        // Логика обработки операции расхода
    }
}
