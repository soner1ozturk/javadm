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

}
