package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo repo;

    public ProductServiceImpl(ProductRepo repo){
        this.repo=repo;
    }

    @Override
    public Product createProduct(Product product){
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProduct(){
        return repo.findAll();
    }

    @Override
    public Product getProductById(Long id){
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public Product updateProduct(Long id, Product product){
        Product exist = getProductById(id);
        exist.setProductName(product.getProductName());
        exist.setPrice(product.getPrice());

        return repo.save(exist);
    }

    @Override
    public void deleteProduct(Long id){
        repo.deleteById(id);
    }

    @Override
    public List<Product> getProductByCategoryName(String categoryName){
        return repo.findByCategory_CategoryName(categoryName);
    }

    @Override
    public List<Product> getProductByProductName(String productName){
        return repo.findByProductName(productName);
    }

    @Override
    public boolean productExistById(Long id){
        return repo.existsById(id);
    }
}
