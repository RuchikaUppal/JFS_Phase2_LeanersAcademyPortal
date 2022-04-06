package com.learnersacademy.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.admin.bean.UserBean;
import com.learnersacademy.admin.service.UserService;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		session.setAttribute(userName, password);
		
		UserBean beanFromUser=new UserBean();
		beanFromUser.setUsername(userName);
		beanFromUser.setPassword(password);
				
		UserService userService=new UserService();
		String userType=userService.logIn(beanFromUser);
		
		
		if(userType==null) 
		{ 
			RequestDispatcher rd=request.getRequestDispatcher("/LoginError.jsp"); 
			rd.forward(request,response); 
		} 
		else if(userType.equals("A")) 
		{ 
			RequestDispatcher rd=request.getRequestDispatcher("/AdminHome.jsp"); 
			rd.forward(request,response); 
		}

	}
}
