package com.food.model;

public class AdminModel {
	   private int adminId;      // admin_id
	    private String username;  // username
	    private String password;
	    
	    
	    public AdminModel() {
	    }
		public AdminModel(int adminId, String username, String password) {
			super();
			this.adminId = adminId;
			this.username = username;
			this.password = password;
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "AdminModel [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
		} 
	    

}
