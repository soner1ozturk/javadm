package com.myapp.demo.controller;
import com.myapp.demo.model.Product;
import com.myapp.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Product> getAll(){
        List<Product> products = productService.findAll();

        if (products.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Product product = productService.findById(id);

        if (product == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }


}
