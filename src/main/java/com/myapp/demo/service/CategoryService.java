package com.myapp.demo.service;

import com.myapp.demo.exception.ProductNotFoundException;
import com.myapp.demo.model.Product;
import com.myapp.demo.model.Category;
import org.springframework.stereotype.Service;
import com.myapp.demo.repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    //ok in this class we basically take our database and do operations on it
    //we create the db
    //then in our constructor we take it as a param
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();

    }



}
