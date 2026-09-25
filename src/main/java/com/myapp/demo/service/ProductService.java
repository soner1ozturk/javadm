package com.myapp.demo.service;
import com.myapp.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Keyboard", 99.99));
        products.add(new Product(2L, "Mouse", 49.99));
        products.add(new Product(3L, "Monitor", 299.99));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product create(Product product) {
        Product created = new Product((long) (products.size() + 1), product.getName(), product.getPrice());
        products.add(created);
        return created;
    }

    public Product update(Long id, Product product){
        Product existing = findById(id);
        if(existing == null){
            return null;
        }
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return existing;
    }

    public boolean delete(Long id){
        return products.removeIf(p -> p.getId().equals(id));
    }


}
