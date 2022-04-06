package com.learnersacademy.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.service.AdminService;

/**
 * Servlet implementation class ClassServlet
 */
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String command = request.getParameter("command");
			
			AdminService adminService=new AdminService();
			
			if(command.equals("CLASSES"))
			{
				List<ClassBean> classList=adminService.viewClasses();
				
				if(classList!=null) 
				{ 
				  request.setAttribute("ClassList", classList);
				  RequestDispatcher rd=request.getRequestDispatcher("/ClassList.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				 
			}
			
			if(command.equals("ADDCLASS"))
			{
				String className=request.getParameter("className");
				String section=request.getParameter("section");
				
				ClassBean classBean=new ClassBean();
				classBean.setClassName(className);
				classBean.setSection(section);
				
				boolean saveStatus=adminService.saveClass(classBean);
				
				if(saveStatus)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.jsp");
					rd.forward(request,response);
				}
			}
			
			if(command.equals("UPDATECLASS"))
			{
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				String className=request.getParameter("className");
				String section=request.getParameter("section");
				
				ClassBean classBean=new ClassBean();
				
				classBean.setClassName(className);
				classBean.setSection(section);
				classBean.setClassId(classId);
				
				boolean updateStatus=adminService.updateClass(classBean);
				
				if(updateStatus)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.jsp");
					rd.forward(request,response);
				}
			}
			
			if(command.equals("DELETECLASS"))
			{
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				
				//out.print("classId method > "+classId);
				int deleteStatus=0;
				
				try 
				{
					deleteStatus= adminService.deleteClass(classId);
					//out.print("deleteStatus method > "+deleteStatus);
				} 
				catch (SQLException e) 
				{
					response.sendRedirect("Fail.jsp");
					
				} 
				
				if(deleteStatus>0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.jsp");
					rd.forward(request,response);
				}
			}
			
			if(command.equals("ASSIGNSUBTOCLASS"))
			{
				String subIdNotAssignedString=request.getParameter("subIdNotAssigned");
				int subIdNotAssigned= Integer.parseInt(subIdNotAssignedString);
				
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				
				ClassSubjectBean classSubBean=new ClassSubjectBean();
				classSubBean.setClassId(classId);
				classSubBean.setSubId(subIdNotAssigned);
				
				boolean saveStatus=adminService.saveClassSubject(classSubBean);
				
				if(saveStatus)
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");
					rd.forward(request,response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.jsp");
					rd.forward(request,response);
				}
			}
			
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
