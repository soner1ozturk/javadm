package com.myapp.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {
    private Map<Long,Order> orderMap;
    private Long id;

    public OrderService(){
        this.orderMap = new HashMap<>();
        this.id = 1L;
    }

    //createOrder(String customerEmail, List<OrderItem> items) — throws IllegalArgumentException if
    // items list is empty, returns the order

    public Order createOrder(String customerEmail, List<OrderItem> items){
        if(items.isEmpty()){
            throw new IllegalArgumentException("List empty.");
        }
        Order newOrder = new Order(id++,customerEmail,items);
        return newOrder;

    }

    //cancelOrder(Long orderId) — throws IllegalArgumentException if not found, throws IllegalStateException
    // if status is SHIPPED or DELIVERED (can't cancel those), sets status to CANCELLED
    public void cancelOrder(Long OrderId){
        if(!orderMap.containsKey(OrderId)){
            throw new IllegalArgumentException("Order not found");
        }
        if(orderMap.get(OrderId).getStatus() == OrderStatus.SHIPPED
                ||orderMap.get(OrderId).getStatus() == OrderStatus.DELIVERED ){
            throw new IllegalStateException("Order delivered or shipped");
        }

        orderMap.remove(OrderId);
    }

    //advanceStatus(Long orderId) — moves the order to the next status
    // (PENDING → CONFIRMED → SHIPPED → DELIVERED), throws if not found,
    // throws IllegalStateException if already DELIVERED or CANCELLED
    public void advanceStatus(Long orderId){
        if(!orderMap.containsKey(orderId)){
            throw new IllegalArgumentException("order not found");
        }
        if(orderMap.get(orderId).getStatus() == OrderStatus.DELIVERED ||
                orderMap.get(orderId).getStatus() == OrderStatus.CANCELLLED ){
            throw new IllegalStateException("Order already Delivered or Cancelled");
        }

        if(orderMap.get(orderId).getStatus() == OrderStatus.PENDING){
            orderMap.get(orderId).setStatus(OrderStatus.CONFIRMED);
        }
        if(orderMap.get(orderId).getStatus() == OrderStatus.CONFIRMED){
            orderMap.get(orderId).setStatus(OrderStatus.SHIPPED);
        }
        if(orderMap.get(orderId).getStatus() == OrderStatus.SHIPPED){
            orderMap.get(orderId).setStatus(OrderStatus.DELIVERED);
        }
    }

    //getOrdersByCustomer(String email) — returns all orders for that email, use streams

    public List<Order> getOrdersByCustomer(String email){
        return orderMap.values().stream().filter(order -> order.getCustomerEmail().equals(email)).collect(Collectors.toList());
    }

    //getTotalRevenue() — returns sum of all order totals where status is NOT CANCELLED, use streams

    public Double getTotalRevenue(){
        List<Order> orders = orderMap.values().stream().filter(order -> order.getStatus() != OrderStatus.CANCELLED).toList();
        return orders.stream().mapToDouble(Order::getOrderTotal).sum();
    }
}
