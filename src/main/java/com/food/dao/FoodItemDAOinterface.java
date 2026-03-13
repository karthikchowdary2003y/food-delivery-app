package com.food.dao;

import java.util.List;
import com.food.model.FoodItemModel;

public interface FoodItemDAOinterface {

    // Add new food item (Admin)
    boolean addFoodItem(FoodItemModel foodItem);

    // Update food item (Admin)
    boolean updateFoodItem(FoodItemModel foodItem);

    // Delete food item (Admin)
    boolean deleteFoodItem(int foodId);

    // Get food item by ID
    FoodItemModel getFoodItemById(int foodId);

    // Get all food items
    List<FoodItemModel> getAllFoodItems();

    // Get food items by restaurant
    List<FoodItemModel> getFoodItemsByRestaurant(int restaurantId);

    // Get food items by category
    List<FoodItemModel> getFoodItemsByCategory(int categoryId);

    // Update food availability (AVAILABLE / NOT_AVAILABLE)
    boolean updateFoodStatus(int foodId, String status);
}
