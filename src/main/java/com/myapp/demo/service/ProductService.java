package com.myapp.demo.service;

import org.springframework.transaction.annotation.Transactional;
import com.myapp.demo.dto.ProductCreateRequest;
import com.myapp.demo.dto.ProductResponse;
import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.model.Category;
import com.myapp.demo.model.Product;
import com.myapp.demo.repository.CategoryRepository;
import com.myapp.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    private ProductResponse toResponse(Product product){
        String categoryName = product.getCategory() != null
                ? product.getCategory().getName()
                : null;
        return new ProductResponse(product.getId(),product.getName(),product.getPrice(),categoryName);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }


    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return toResponse(product);
    }


    public ProductResponse create(ProductCreateRequest request) {
        Product product = new Product(request.getName(), request.getPrice());
        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        return toResponse(productRepository.save(product));
    }



    @Transactional
    public ProductResponse update(Long id, ProductCreateRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        return toResponse(productRepository.save(existing));
    }                                                        // ← update ends here


    @Transactional
    public void delete(Long id) {                           // ← delete starts here
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
}
