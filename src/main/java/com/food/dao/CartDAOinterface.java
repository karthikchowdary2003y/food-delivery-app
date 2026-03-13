package com.food.dao;

import java.util.List;
import com.food.model.CartModel;

public interface CartDAOinterface {

    // Add item to cart
    boolean addToCart(CartModel cart);

    // Update quantity in cart
    boolean updateCartItem(CartModel cart);

    // Remove single item from cart
    boolean removeCartItem(int cartId);

    // Clear entire cart for a user
    boolean clearCartByUser(int userId);

    // Get all cart items by user
    List<CartModel> getCartItemsByUser(int userId);

    // Check if food already exists in cart
    CartModel getCartItemByUserAndFood(int userId, int foodId);
}
