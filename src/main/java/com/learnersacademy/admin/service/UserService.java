package com.learnersacademy.admin.service;

import com.learnersacademy.admin.bean.UserBean;
import com.learnersacademy.admin.dao.UserDao;

public class UserService {
	
	UserDao userDao=new UserDao();
	
	public String logIn(UserBean beanFromUser) 
	{
		UserBean beanFromDB=userDao.getUserByUserName(beanFromUser.getUsername());
		String userType=null;
		
		if (beanFromDB!=null)
		{
			if(beanFromDB.getUsername().equals(beanFromUser.getUsername()) && beanFromDB.getPassword().equals(beanFromUser.getPassword()))
			{
				userType=beanFromDB.getUserType();			
			}
		}
		
		return userType;
	}
	
	public void logOut(UserBean beanFromUser)
	{
		
	}
	

}
