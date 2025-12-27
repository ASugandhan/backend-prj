package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
    Page<Category> findByCategoryNameContainingIgnoreCase(String categoryName,Pageable pageable);
}
