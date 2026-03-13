package com.food.dao;

import com.food.model.UserModel;
import com.food.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOinterface {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 🔹 Register User
    @Override
    public boolean registerUser(UserModel user) {

        boolean status = false;

        try {
            con = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int result = ps.executeUpdate();
            if (result > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 🔹 Login User
    @Override
    public UserModel loginUser(String email, String password) {
        UserModel user = null;
        try {
            con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role")); // <-- important
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    // 🔹 Get User By ID
    @Override
    public UserModel getUserById(int userId) {

        UserModel user = null;

        try {
            con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE user_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // 🔹 Get All Users (Admin)
    @Override
    public List<UserModel> getAllUsers() {

        List<UserModel> list = new ArrayList<>();

        try {
            con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 Delete User
    @Override
    public boolean deleteUser(int userId) {

        boolean status = false;

        try {
            con = DBConnection.getConnection();

            String sql = "DELETE FROM users WHERE user_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            int result = ps.executeUpdate();
            if (result > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
