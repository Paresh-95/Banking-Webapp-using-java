package com.jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	
	public static Connection connect()
	{
		Connection con = null;
		try {
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println("Driver Loaded");
	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rcbank","root","") ;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Connection Established");
	
		return(con); 
	}
}
	