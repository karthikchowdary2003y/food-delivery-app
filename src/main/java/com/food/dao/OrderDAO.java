package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.model.OrderModel;
import com.food.utility.DBConnection;

public class OrderDAO implements OrderDAOinterface {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // 1️⃣ Place new order
    @Override
    public boolean placeOrder(OrderModel order) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            String sql = "INSERT INTO orders (user_id, total_amount, order_status) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getOrderStatus()); // ✅ CORRECT

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 2️⃣ Get order by ID
    @Override
    public OrderModel getOrderById(int orderId) {
        OrderModel order = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM orders WHERE order_id=?");
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            if (rs.next()) {
                order = new OrderModel(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("total_amount"),
                        rs.getString("order_status"), // ✅ CORRECT
                        rs.getTimestamp("order_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    // 3️⃣ Get all orders by user
    @Override
    public List<OrderModel> getOrdersByUser(int userId) {
        List<OrderModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM orders WHERE user_id=?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new OrderModel(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("total_amount"),
                        rs.getString("order_status"),
                        rs.getTimestamp("order_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 4️⃣ Get all orders (Admin)
    @Override
    public List<OrderModel> getAllOrders() {
        List<OrderModel> list = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM orders");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new OrderModel(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("total_amount"),
                        rs.getString("order_status"),
                        rs.getTimestamp("order_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 5️⃣ Update order status (Admin)
    @Override
    public boolean updateOrderStatus(int orderId, String orderStatus) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                    "UPDATE orders SET order_status=? WHERE order_id=?");

            ps.setString(1, orderStatus);
            ps.setInt(2, orderId);

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 6️⃣ Delete order
    @Override
    public boolean deleteOrder(int orderId) {
        boolean result = false;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM orders WHERE order_id=?");
            ps.setInt(1, orderId);

            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
