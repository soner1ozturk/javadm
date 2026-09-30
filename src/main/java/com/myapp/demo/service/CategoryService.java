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

    public List<CategoryResponse> findAll(){
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

    }

    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(RuntimeException);
        return toResponse(category);

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
