package com.food.dao;

import java.util.List;
import com.food.model.RestaurantModel;

public interface RestaurantDAOinterface {

    // Add new restaurant (Admin)
    boolean addRestaurant(RestaurantModel restaurant);

    // Update restaurant details
    boolean updateRestaurant(RestaurantModel restaurant);

    // Delete restaurant
    boolean deleteRestaurant(int restaurantId);

    // Get restaurant by ID
    RestaurantModel getRestaurantById(int restaurantId);

    // Get all restaurants (index.jsp)
    List<RestaurantModel> getAllRestaurants();

    // Get restaurants by category (optional)
    List<RestaurantModel> getRestaurantsByCategory(int categoryId);

    // Update restaurant status (OPEN / CLOSED)
    boolean updateRestaurantStatus(int restaurantId, String status);
}
