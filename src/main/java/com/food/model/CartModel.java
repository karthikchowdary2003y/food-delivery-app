package com.food.model;

public class CartModel {
	 private int cartId;     // cart_id
	    private int userId;     // user_id
	    private int foodId;     // food_id
	    private int quantity;   // quantity

	    // 🔹 No-argument constructor
	    public CartModel() {
	    }

		public CartModel(int cartId, int userId, int foodId, int quantity) {
			super();
			this.cartId = cartId;
			this.userId = userId;
			this.foodId = foodId;
			this.quantity = quantity;
		}

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
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

		@Override
		public String toString() {
			return "CartModel [cartId=" + cartId + ", userId=" + userId + ", foodId=" + foodId + ", quantity="
					+ quantity + "]";
		}
	    

}
