package com.myapp.demo.dto;

import com.myapp.demo.model.Product;

import java.util.List;

public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){return id;}
    public String getName(){return name;}
    public List<Product> getProducts(){return products;}
    public void setName(String name){this.name = name;}
}
