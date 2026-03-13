package com.food.dao;

import java.util.List;
import com.food.model.CategoryModel;

public interface CategoryDAOinterface {

    // Add new category (Admin)
    boolean addCategory(CategoryModel category);

    // Update category name
    boolean updateCategory(CategoryModel category);

    // Delete category
    boolean deleteCategory(int categoryId);

    // Get category by ID
    CategoryModel getCategoryById(int categoryId);

    // Get all categories
    List<CategoryModel> getAllCategories();
}
