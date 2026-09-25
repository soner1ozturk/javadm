package com.myapp.demo.controller;
import com.myapp.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Product> getAll(){
        List<Product> products = List.of(
                new Product(1L,"Keyboard",99.99),
                new Product(2L,"Mouse",49.99),
                new Product(3L,"Monitor",299.99)
        );
        return products;
    }
}
