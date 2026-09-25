package com.myapp.demo.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Product {

    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    public Product(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public void setName(String name){this.name = name;}
    public void setPrice(double price){this.price = price;}
}
