package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findByProductName(String productName);
}
