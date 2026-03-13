package com.food.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.food.model.FoodItemModel;
import com.food.utility.DBConnection;

public class FoodItemDAO implements FoodItemDAOinterface {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 🔹 Add Food Item
    @Override
   
    public boolean addFoodItem(FoodItemModel foodItem) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO food_items "
                       + "(restaurant_id, category_id, name, price, image, description, status) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, foodItem.getRestaurantId());
            ps.setInt(2, foodItem.getCategoryId());
            ps.setString(3, foodItem.getName());
            ps.setDouble(4, foodItem.getPrice());
            ps.setString(5, foodItem.getImage());
            ps.setString(6, foodItem.getDescription());
            ps.setString(7, foodItem.getStatus());

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    // 🔹 Update Food Item
    @Override
    public boolean updateFoodItem(FoodItemModel foodItem) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            
            String sql = "UPDATE food_items SET restaurant_id=?, category_id=?, name=?, price=?, image=?, description=?, status=? WHERE food_id=?";
;

            ps = con.prepareStatement(sql);
            ps.setInt(1, foodItem.getRestaurantId());
            ps.setInt(2, foodItem.getCategoryId());
            ps.setString(3, foodItem.getName());
            ps.setDouble(4, foodItem.getPrice());
            ps.setString(5, foodItem.getImage());
            ps.setString(6, foodItem.getDescription());
            ps.setString(7, foodItem.getStatus());
            ps.setInt(8, foodItem.getFoodId());
        
            status = ps.executeUpdate() > 0;
         

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 🔹 Delete Food Item
    @Override
    public boolean deleteFoodItem(int foodId) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM food_items WHERE food_id=?");
            ps.setInt(1, foodId);
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 🔹 Get Food Item By ID
    @Override
    public FoodItemModel getFoodItemById(int foodId) {
        FoodItemModel food = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM food_items WHERE food_id=?");
            ps.setInt(1, foodId);
            rs = ps.executeQuery();

            if (rs.next()) {
                food = new FoodItemModel(
                        rs.getInt("food_id"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return food;
    }

    // 🔹 Get All Food Items
    @Override
    public List<FoodItemModel> getAllFoodItems() {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM food_items");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FoodItemModel(
                        rs.getInt("food_id"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔹 Get Food Items By Restaurant
    @Override
    public List<FoodItemModel> getFoodItemsByRestaurant(int restaurantId) {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM food_items WHERE restaurant_id=?");
            ps.setInt(1, restaurantId);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FoodItemModel(
                        rs.getInt("food_id"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔹 Get Food Items By Category
    public List<FoodItemModel> getFoodItemsByCategory(int categoryId) {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM food_items WHERE category_id=? AND status='AVAILABLE'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodItemModel f = new FoodItemModel();
                f.setFoodId(rs.getInt("food_id"));
                f.setRestaurantId(rs.getInt("restaurant_id"));
                f.setCategoryId(rs.getInt("category_id"));
                f.setName(rs.getString("name"));
                f.setPrice(rs.getDouble("price"));
                f.setImage(rs.getString("image"));
                f.setDescription(rs.getString("description"));
                f.setStatus(rs.getString("status"));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    // 🔹 Update Food Status
    @Override
    public boolean updateFoodStatus(int foodId, String statusValue) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                    "UPDATE food_items SET status=? WHERE food_id=?");
            ps.setString(1, statusValue);
            ps.setInt(2, foodId);
            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public List<FoodItemModel> getAvailableFoodItemsByCategory(int categoryId) {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                "SELECT * FROM food_items WHERE status='active' AND category_id=?"
            );
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new FoodItemModel(
                    rs.getInt("food_id"),
                    rs.getInt("restaurant_id"),
                    rs.getInt("category_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("image"),
                    rs.getString("description"),
                    rs.getString("status")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<FoodItemModel> getAvailableFoodItems() {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM food_items WHERE status='active'");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodItemModel(
                    rs.getInt("food_id"),
                    rs.getInt("restaurant_id"),
                    rs.getInt("category_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("image"),
                    rs.getString("description"),
                    rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<FoodItemModel> getFoodItemsByRestaurantAndCategory(int restaurantId, int categoryId) {
        List<FoodItemModel> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM food_items WHERE restaurant_id=? AND category_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantId);
            ps.setInt(2, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodItemModel f = new FoodItemModel();
                f.setFoodId(rs.getInt("food_id"));
                f.setRestaurantId(rs.getInt("restaurant_id"));
                f.setCategoryId(rs.getInt("category_id"));
                f.setName(rs.getString("name"));
                f.setPrice(rs.getDouble("price"));
                f.setImage(rs.getString("image"));
                f.setDescription(rs.getString("description"));
                f.setStatus(rs.getString("status"));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
