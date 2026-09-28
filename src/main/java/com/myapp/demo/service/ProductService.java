package com.myapp.demo.service;
import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.model.Product;
import org.springframework.stereotype.Service;
import com.myapp.demo.repository.ProductRepository;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product create(Product product) {
        Product created = new Product(product.getName(), product.getPrice());
        products.add(created);
        return created;
    }

    public Product update(Long id, Product product){
        Product existing = findById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return existing;
    }

    public boolean delete(Long id){
        return products.removeIf(p -> p.getId().equals(id));
    }


}
