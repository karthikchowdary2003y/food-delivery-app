package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.model.CartModel;
import com.food.utility.DBConnection;

public class CartDAO implements CartDAOinterface {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 1️⃣ Add item to cart
    @Override
    public boolean addToCart(CartModel cart) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO cart (user_id, food_id, quantity) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getFoodId());
            ps.setInt(3, cart.getQuantity());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 2️⃣ Update quantity
    @Override
    public boolean updateCartItem(CartModel cart) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE cart SET quantity=? WHERE cart_id=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, cart.getQuantity());
            ps.setInt(2, cart.getCartId());

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 3️⃣ Remove single item
    @Override
    public boolean removeCartItem(int cartId) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM cart WHERE cart_id=?");
            ps.setInt(1, cartId);

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 4️⃣ Clear cart by user
    @Override
    public boolean clearCartByUser(int userId) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM cart WHERE user_id=?");
            ps.setInt(1, userId);

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 5️⃣ Get all cart items by user
    @Override
    public List<CartModel> getCartItemsByUser(int userId) {
        List<CartModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM cart WHERE user_id=?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CartModel(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        rs.getInt("food_id"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 6️⃣ Check if food already exists in cart
    @Override
    public CartModel getCartItemByUserAndFood(int userId, int foodId) {
        CartModel cart = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                    "SELECT * FROM cart WHERE user_id=? AND food_id=?");
            ps.setInt(1, userId);
            ps.setInt(2, foodId);
            rs = ps.executeQuery();

            if (rs.next()) {
                cart = new CartModel(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        rs.getInt("food_id"),
                        rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }
}
