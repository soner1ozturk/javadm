package com.myapp.demo.service;

import org.springframework.transaction.annotation.Transactional;
import com.myapp.demo.dto.CategoryCreateRequest;
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
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return toResponse(category);

    }

    public CategoryResponse create(CategoryCreateRequest request) {
        Category category = new Category(request.getName());
        return toResponse(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponse update(Long id, CategoryCreateRequest request) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        existing.setName(request.getName());
        return toResponse(categoryRepository.save(existing));
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        categoryRepository.deleteById(id);
    }



}
