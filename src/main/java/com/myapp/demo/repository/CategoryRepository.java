package com.myapp.demo.repository;
import com.myapp.demo.model.Product;
import com.myapp.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
}
