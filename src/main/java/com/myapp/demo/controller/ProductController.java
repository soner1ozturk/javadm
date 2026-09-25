package com.myapp.demo.controller;
import com.myapp.demo.model.Product;
import com.myapp.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Product product = productService.findById(id);

        if (product == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product created = productService.create(product);
        return ResponseEntity.status(201).body(created);
    }


}
