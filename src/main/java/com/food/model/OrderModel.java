package com.food.model;

import java.sql.Timestamp;

public class OrderModel {
	
	  private int orderId;           // order_id
	    private int userId;            // user_id
	    private double totalAmount;    // total_amount
	    private String orderStatus;    // order_status
	    private Timestamp orderDate;   // order_date

	    // 🔹 No-argument constructor
	    public OrderModel() {
	    }

		public OrderModel(int orderId, int userId, double totalAmount, String orderStatus, Timestamp orderDate) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			this.totalAmount = totalAmount;
			this.orderStatus = orderStatus;
			this.orderDate = orderDate;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		public Timestamp getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Timestamp orderDate) {
			this.orderDate = orderDate;
		}

		@Override
		public String toString() {
			return "OrderModel [orderId=" + orderId + ", userId=" + userId + ", totalAmount=" + totalAmount
					+ ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
		}
	    


}
