package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.service.ProductService;
import com.examly.springapp.model.Product;
import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service= service;
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product){
        Product saved = service.createProduct(product);
       return  ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Product> get1(){
        return service.getAllProduct();
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> get3(@PathVariable String categoryName){
        return service.getProductByCategoryName(categoryName);
    }
    
    @GetMapping("/{id}")
    public Product get2(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product put(@PathVariable Long id , @RequestBody Product product){
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!service.productExistById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product is found with that id");
        }
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/name/{productName}")
    public ResponseEntity<?> get4(@PathVariable String productName){
        List<Product> products= service.getProductByProductName(productName);

        if(products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found with name: " + productName);
        }

        return ResponseEntity.ok(products);
    }
}
