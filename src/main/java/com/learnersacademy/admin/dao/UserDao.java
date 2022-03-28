package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.learnersacademy.admin.bean.UserBean;
import com.learnersacademy.admin.util.DBConnection;

public class UserDao {
	
	  public static void main(String[] args) { UserDao Dao=new UserDao();
	  Dao.getUserByUserName("admin"); }
	 
	
	public UserBean getUserByUserName(String userName)
	{
		UserBean userBean=new UserBean();
		
		try 
		{
			Connection con= DBConnection.getConnection();
			Statement stmt= con.createStatement();
			String query= "Select * from LA_User where username='"+userName+"'";
			
			//System.out.println(query);
			ResultSet rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				userBean.setUserId(rs.getInt("userId"));
				userBean.setUsername(rs.getString("username"));
				userBean.setPassword(rs.getString("password"));
				userBean.setUserType(rs.getString("usertype"));
				
			}
			else
			{
				userBean=null;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBean;
	}
	

}
