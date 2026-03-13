package com.food.model;

public class OrderItemModel {

    private int orderItemId;   // order_item_id
    private int orderId;       // order_id
    private int foodId;        // food_id
    private int quantity;      // quantity
    private double price;      // price (per item or total for qty)

    // 🔹 No-argument constructor
    public OrderItemModel() {
    }

	public OrderItemModel(int orderItemId, int orderId, int foodId, int quantity, double price) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItemModel [orderItemId=" + orderItemId + ", orderId=" + orderId + ", foodId=" + foodId
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
    

}
