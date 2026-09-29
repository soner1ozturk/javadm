package com.myapp.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable=false)
    private String name;


    @Min(value = 0, message = "Price cannot be negative")
    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Product(){};
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Category getCategory(){return category;}
    public void setCategory(Category category){this.category = category;}

    public Long getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public void setName(String name){this.name = name;}
    public void setPrice(double price){this.price = price;}
}
