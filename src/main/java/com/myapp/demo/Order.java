package com.myapp.demo;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //Order class with: Long id, String customerEmail, List<OrderItem> items, OrderStatus status.
    // Constructor takes id, customerEmail, and items. Status starts as PENDING.
    // Add a method getOrderTotal() that uses streams to sum all item totals.

    private Long id;
    private String customerEmail;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(Long id, String customerEmail, List<OrderItem> items){
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = items;
        this.status = OrderStatus.PENDING;
    }

    public Double getOrderTotal(){
        return items.stream().mapToDouble(OrderItem::getTotal).sum();
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }
}
