package com.myapp.demo.service;
import com.myapp.demo.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    public List<Product> findAll(){
        List<Product> products = List.of(
                new Product(1L,"Keyboard",99.99),
                new Product(2L,"Mouse",49.99),
                new Product(3L,"Monitor",299.99)
        );
        return products;
    }


}
