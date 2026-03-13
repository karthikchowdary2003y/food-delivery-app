package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.model.RestaurantModel;
import com.food.utility.DBConnection;

public class RestaurantDAO implements RestaurantDAOinterface {

    Connection con;

    // 1️⃣ Add new restaurant
    @Override
    public boolean addRestaurant(RestaurantModel restaurant) {
        try {
            con = new DBConnection().getConnection();

            String sql = "INSERT INTO restaurants (name, image, rating, location, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getImage());
            ps.setDouble(3, restaurant.getRating());
            ps.setString(4, restaurant.getLocation());
            ps.setString(5, restaurant.getStatus());

            return ps.executeUpdate() > 0;
        

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("rows afected");
        return false;
    }

    // 2️⃣ Update restaurant
    @Override
    public boolean updateRestaurant(RestaurantModel restaurant) {
        try {
            con = new DBConnection().getConnection();

            String sql = "UPDATE restaurants SET name=?, image=?, rating=?, location=?, status=? WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getImage());
            ps.setDouble(3, restaurant.getRating());
            ps.setString(4, restaurant.getLocation());
            ps.setString(5, restaurant.getStatus());
            ps.setInt(6, restaurant.getRestaurantId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 3️⃣ Delete restaurant
    @Override
    public boolean deleteRestaurant(int restaurantId) {
        try {
            con = new DBConnection().getConnection();

            String sql = "DELETE FROM restaurants WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // 4️⃣ Get restaurant by ID
    @Override
    public RestaurantModel getRestaurantById(int restaurantId) {
        RestaurantModel r = null;

        try {
            con = new DBConnection().getConnection();

            String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = new RestaurantModel();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setImage(rs.getString("image"));
                r.setRating(rs.getDouble("rating"));
                r.setLocation(rs.getString("location"));
                r.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }

    // 5️⃣ Get all restaurants (index.jsp)
    @Override
    public List<RestaurantModel> getAllRestaurants() {
        List<RestaurantModel> list = new ArrayList<>();

        try {
            con = new DBConnection().getConnection();

            String sql = "SELECT * FROM restaurants";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RestaurantModel r = new RestaurantModel();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setImage(rs.getString("image"));
                r.setRating(rs.getDouble("rating"));
                r.setLocation(rs.getString("location"));
                r.setStatus(rs.getString("status"));
                list.add(r);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // 6️⃣ Get restaurants by category (⚠️ NOT POSSIBLE YET)
    @Override
    public List<RestaurantModel> getRestaurantsByCategory(int categoryId) {

        // ⚠️ This will work ONLY if you add category_id column
        // ALTER TABLE restaurants ADD category_id INT;

        List<RestaurantModel> list = new ArrayList<>();

        try {
            con = new DBConnection().getConnection();

            String sql = "SELECT * FROM restaurants WHERE category_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RestaurantModel r = new RestaurantModel();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setImage(rs.getString("image"));
                r.setRating(rs.getDouble("rating"));
                r.setLocation(rs.getString("location"));
                r.setStatus(rs.getString("status"));
                list.add(r);
            }

        } catch (Exception e) {
            System.out.println("Category not supported yet: " + e);
        }
        return list;
    }

    // 7️⃣ Update restaurant status (OPEN / CLOSED)
    @Override
    public boolean updateRestaurantStatus(int restaurantId, String status) {
        try {
            con = new DBConnection().getConnection();

            String sql = "UPDATE restaurants SET status=? WHERE restaurant_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, restaurantId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
