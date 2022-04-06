package com.learnersacademy.admin.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con=null;
	public static Connection getConnection()
	{
		if(con==null)
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System","admin");
				System.out.println("Connection successfull");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return con;
	}
}
