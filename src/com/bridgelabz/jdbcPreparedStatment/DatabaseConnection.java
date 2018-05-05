package com.bridgelabz.jdbcPreparedStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	public static Connection getconnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDemo","root","password");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
