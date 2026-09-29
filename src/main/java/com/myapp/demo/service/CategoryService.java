package com.myapp.demo.service;

import com.myapp.demo.dto.CategoryResponse;
import com.myapp.demo.model.Category;
import org.springframework.stereotype.Service;
import com.myapp.demo.repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private CategoryResponse toResponse(Category category){
        return new CategoryResponse(category.getId(),category.getName());
    }
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();

    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category existing = findById(id);
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }

    public void delete(Long id){
        findById(id);
        categoryRepository.deleteById(id);
    }



}
