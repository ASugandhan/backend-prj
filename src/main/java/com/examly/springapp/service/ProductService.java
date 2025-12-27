package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.*;

public interface ProductService {
        Product createProduct(Product product);
        List<Product> getAllProduct();
        Product getProductById(Long id);
        Product updateProduct(Long id, Product product);
        void deleteProduct(Long id);
        List<Product> getProductByCategoryName(String categoryName);
        List<Product> getProductByProductName(String productName);
        boolean productExistById(Long id);
} 
