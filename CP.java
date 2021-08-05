package com.my_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
   static Connection con;
	public static Connection createc() {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection..
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/book_shop","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
