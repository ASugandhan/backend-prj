package com.examly.springapp.service;
import com.examly.springapp.model.Category;
import java.util.*;

import org.springframework.data.domain.Page;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(Long id);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Long id);

    Page<Category> getCategoriesPage(int page,int size,String sortBy);

    Page<Category> searchCategories(
        int page,
        int size,
        String sortBy,
        String direction,
        String search
    );
}
