package com.food.dao;

import java.util.List;
import com.food.model.*;

public interface AdminDAOinterface {

	  AdminModel loginAdmin(String username, String password);

	    // Get admin by ID
	    AdminModel getAdminById(int adminId);

	    // Get all admins
	    List<AdminModel> getAllAdmins();

	    // Add new admin
	    boolean addAdmin(AdminModel admin);

	    // Update admin
	    boolean updateAdmin(AdminModel admin);

	    // Delete admin
	    boolean deleteAdmin(int adminId);
}
