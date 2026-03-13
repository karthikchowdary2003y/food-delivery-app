package com.food.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {

        try {
            // 1️⃣ Load MySQL JDBC Driver
        	
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Create connection
            
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "root"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
