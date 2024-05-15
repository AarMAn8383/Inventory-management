package com.example.inventorymanagementsystem;

import java.io.*;
import java.util.List;

public class InventoryFileHandler {
    public void saveInventoryToFile(List<Product> products, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> loadInventoryFromFile(String filename) {
        List<Product> products = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
