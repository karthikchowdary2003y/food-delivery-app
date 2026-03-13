package com.food.dao;

import java.util.List;
import com.food.model.OrderModel;

public interface OrderDAOinterface {

    // Place new order
    boolean placeOrder(OrderModel order);

    // Get order by ID
    OrderModel getOrderById(int orderId);

    // Get all orders by user
    List<OrderModel> getOrdersByUser(int userId);

    // Get all orders (Admin)
    List<OrderModel> getAllOrders();

    // Update order status (Admin)
    boolean updateOrderStatus(int orderId, String status);

    // Delete order (optional / admin)
    boolean deleteOrder(int orderId);
}
