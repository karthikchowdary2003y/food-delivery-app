package com.food.model;

public class FoodItemModel {
	 private int foodId;          // food_id
	    private int restaurantId;    // restaurant_id
	    private int categoryId;      // category_id
	    private String name;         // name
	    private double price;        // price
	    private String image;        // image
	    private String description; // description
	    private String status;       // status (AVAILABLE / UNAVAILABLE)

	    // 🔹 No-argument constructor
	    public FoodItemModel() {
	    }

		public FoodItemModel(int foodId, int restaurantId, int categoryId, String name, double price, String image,
				String description, String status) {
			super();
			this.foodId = foodId;
			this.restaurantId = restaurantId;
			this.categoryId = categoryId;
			this.name = name;
			this.price = price;
			this.image = image;
			this.description = description;
			this.status = status;
		}

		public int getFoodId() {
			return foodId;
		}

		public void setFoodId(int foodId) {
			this.foodId = foodId;
		}

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "FoodItemModel [foodId=" + foodId + ", restaurantId=" + restaurantId + ", categoryId=" + categoryId
					+ ", name=" + name + ", price=" + price + ", image=" + image + ", description=" + description
					+ ", status=" + status + "]";
		}
	    

}
