package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.model.AdminModel;
import com.food.utility.DBConnection;

public class AdminDAO implements AdminDAOinterface {

    Connection con = DBConnection.getConnection();

    // 1️⃣ Admin Login
    @Override
    public AdminModel loginAdmin(String username, String password) {

        AdminModel admin = null;

        try {
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                admin = new AdminModel();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

    // 2️⃣ Get admin by ID
    @Override
    public AdminModel getAdminById(int adminId) {

        AdminModel admin = null;

        try {
            String sql = "SELECT * FROM admin WHERE admin_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, adminId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                admin = new AdminModel();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

    // 3️⃣ Get all admins
    @Override
    public List<AdminModel> getAllAdmins() {

        List<AdminModel> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM admin";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AdminModel admin = new AdminModel();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                list.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 4️⃣ Add admin
    @Override
    public boolean addAdmin(AdminModel admin) {

        boolean status = false;

        try {
            String sql = "INSERT INTO admin(username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 5️⃣ Update admin
    @Override
    public boolean updateAdmin(AdminModel admin) {

        boolean status = false;

        try {
            String sql = "UPDATE admin SET username=?, password=? WHERE admin_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setInt(3, admin.getAdminId());

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 6️⃣ Delete admin
    @Override
    public boolean deleteAdmin(int adminId) {

        boolean status = false;

        try {
            String sql = "DELETE FROM admin WHERE admin_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, adminId);

            status = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
