package com.myapp.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    public String getName(){return name;}
}
