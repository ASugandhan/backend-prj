package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody(required = false) Category category){
        if(category == null){
            return ResponseEntity.badRequest().build();
        }
        Category saved = service.createCategory(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = service.getAllCategory();
        if(categories == null || categories.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateById(@PathVariable Long id,@RequestBody Category category){
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        service.deleteCategory(id);
        return "Category deleted Successfully";
    }

    @GetMapping("/page")
    public Page<Category> getCategoriesPage(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "categoryId") String sortBy
    ){
        return service.getCategoriesPage(page,size,sortBy);
    }

    @GetMapping("/page/{page}/{size}")
    public Page<Category> getCategoriesPageByPath(@PathVariable int page, @PathVariable int size){
        return service.getCategoriesPage(page, size,"categoryId");
    }

    @GetMapping("/page/search")
    public Page<Category> searchCategories(
        @RequestParam (defaultValue = "0") int page,
        @RequestParam (defaultValue = "5") int size,
        @RequestParam (defaultValue = "categoryId") String sortBy,
        @RequestParam (defaultValue = "asc") String direction,
        @RequestParam (required = false) String search
    )
    {
        return service.searchCategories(page, size, sortBy, direction, search);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> handleValidationError(){
        return ResponseEntity.badRequest().build();
    }
}

