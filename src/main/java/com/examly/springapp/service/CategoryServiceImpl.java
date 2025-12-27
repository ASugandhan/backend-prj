package com.examly.springapp.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.examly.springapp.repository.CategoryRepo;
import com.examly.springapp.model.Category;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo repository;

    public CategoryServiceImpl(CategoryRepo repository){
        this.repository=repository;
    }

    @Override
    public Category createCategory(Category category){
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategory(){
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(Long id){
        return repository.findById(id)
            .orElseThrow(()-> new RuntimeException("Category not found with id "+ id));
    }

    @Override
    public Category updateCategory(Long id,Category category){
        Category existing = getCategoryById(id);
        existing.setCategoryName(category.getCategoryName());
        return repository.save(existing);
    }

    @Override
    public void deleteCategory(Long id){
        repository.deleteById(id);
    }

    @Override
    public Page<Category> getCategoriesPage(int page,int size,String sortBy){
        PageRequest pageable= PageRequest.of(page,size,Sort.by(sortBy));

        return repository.findAll(pageable);
    }

    @Override
    public Page<Category> searchCategories(
        int page,
        int size,
        String sortBy,
        String direction,
        String search
    ){
        Sort sort = direction.equalsIgnoreCase("desc")
        ? Sort.by(sortBy).descending()
        : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);

        if(search != null && !search.isBlank()){
            return repository.findByCategoryNameContainingIgnoreCase(search,pageable);
        }

        return repository.findAll(pageable);

    }

}
