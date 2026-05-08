package com.myapp.demo;

import org.springframework.core.annotation.Order;

public class OrderItem {
    //OrderItem class with: String productName, int quantity, double pricePerUnit.
    // Add a method getTotal() that returns quantity * pricePerUnit.

    private String productName;
    private int quantity;
    private double pricePerUnit;

    public OrderItem(String productName,int quantity, double pricePerUnit){
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;

    }

    public Double getTotal(){
        return quantity * pricePerUnit;
    }
}
