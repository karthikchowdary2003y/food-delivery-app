package com.food.model;

public class RestaurantModel {

	private int restaurantId;
	private String name;
	private int categoryId;
	private String image;
	private double rating;
	private String location;
	private String status;

    public RestaurantModel() {
    }

	public RestaurantModel(int restaurantId, String name, int categoryId, String image, double rating, String location,
			String status) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.categoryId = categoryId;
		this.image = image;
		this.rating = rating;
		this.location = location;
		this.status = status;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RestaurantModel [restaurantId=" + restaurantId + ", name=" + name + ", categoryId=" + categoryId
				+ ", image=" + image + ", rating=" + rating + ", location=" + location + ", status=" + status + "]";
	}
    
    
    

}