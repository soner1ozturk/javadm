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

    public Product findById(Long id){
        return findAll().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Product create(Product product){
        return new Product(4L,product.getName(),product.getPrice());
    }

    public Product update(Long id, Product product){
        Product existing = findById(id);
        if(existing == null){
            return null;
        }
        existing.setName(product.getName());
        existing.setPrice(product.setPrice());
        return exiting;
    }

    public boolean delete(Long id){
        return products.removeIf(p -> p.getId().equals(id));
    }


}
