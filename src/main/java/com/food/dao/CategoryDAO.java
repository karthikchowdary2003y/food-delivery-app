package com.food.dao;

import com.food.model.CategoryModel;
import com.food.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements CategoryDAOinterface {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // ADD CATEGORY
    @Override
    public boolean addCategory(CategoryModel category) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO categories (category_name, image) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // UPDATE CATEGORY
    @Override
    public boolean updateCategory(CategoryModel category) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE categories SET category_name=?, image=? WHERE category_id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getCategoryId());

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // DELETE CATEGORY
    @Override
    public boolean deleteCategory(int categoryId) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String sql =  "DELETE FROM categories WHERE category_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // GET CATEGORY BY ID
    @Override
    public CategoryModel getCategoryById(int categoryId) {
        CategoryModel category = null;
        try {
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM categories";
            ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);

            rs = ps.executeQuery();
            if (rs.next()) {
            	CategoryModel c = new CategoryModel();
            	c.setCategoryId(rs.getInt("category_id"));
            	c.setCategoryName(rs.getString("category_name"));
            	c.setImage(rs.getString("image")); // add this
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    // GET ALL CATEGORIES
    @Override
    public List<CategoryModel> getAllCategories() {

        List<CategoryModel> list = new ArrayList<>();

        try {
            con = DBConnection.getConnection();

            String sql = "SELECT * FROM categories"; // ✅ NO WHERE
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setImage(rs.getString("image"));
                list.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
