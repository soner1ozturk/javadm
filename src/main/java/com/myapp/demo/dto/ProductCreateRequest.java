package com.myapp.demo.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class ProductCreateRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    private Long categoryId;

    public String getName(){return name;}
    public double getPrice(){return price;}
    public Long getCategoryId(){return categoryId;}

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}
