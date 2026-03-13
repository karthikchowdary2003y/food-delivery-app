package com.food.dao;

import java.util.List;

import com.food.model.UserModel;

public interface UserDAOinterface {
	   // 🔹 Register new user
    boolean registerUser(UserModel user);

    // 🔹 Login user
    UserModel loginUser(String email, String password);

    // 🔹 Get user by ID
    UserModel getUserById(int userId);

    // 🔹 Get all users (Admin use)
    List<UserModel> getAllUsers();

    // 🔹 Delete user (Admin)
    boolean deleteUser(int userId);

}
