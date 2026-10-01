package com.myapp.demo.service;
import com.myapp.demo.dto.ProductResponse;
import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.model.Product;
import com.myapp.demo.repository.CategoryRepository;
import com.myapp.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findById_returnsProduct_whenExist(){
        Product product = new Product("Keyboard", 99.99);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ProductResponse response = productService.findById(1L);

        assertEquals("Keyboard",response.getName());
        assertEquals(99.99,response.getPrice());
    }

    @Test
    void findById_throwsException_whenNotFound(){
        when(productRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.findById(99L));
    }
}
