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

import com.learnersacademy.admin.bean.StudentBean;
import com.learnersacademy.admin.service.AdminService;

/**
 * Servlet implementation class ClassServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String command = request.getParameter("command");

			PrintWriter out=response.getWriter();
			out.print("command : " +command);
			
			AdminService adminService=new AdminService();
			
			if(command.equals("STUDENTS"))
			{
				List<StudentBean> studentList=adminService.viewStudents();
				
				if(studentList!=null) 
				{ 
				  request.setAttribute("StudentList", studentList);
				  RequestDispatcher rd=request.getRequestDispatcher("/StudentList.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				 
			}
			
			if(command.equals("ADDSTUDENT"))
			{
				String studentFName=request.getParameter("studentFName");
				String studentLName=request.getParameter("studentLName");
				String classIdString=request.getParameter("classId").toString();
				int classId= Integer.parseInt(classIdString);
				
				StudentBean studentBean=new StudentBean();
				studentBean.setStudentFirstName(studentFName);
				studentBean.setStudentLastName(studentLName);
				studentBean.setClassId(classId);
				
				boolean saveStatus=adminService.saveStudent(studentBean);
				
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
			
			if(command.equals("UPDATESTUDENT"))
				
			{
				out.print("command : "+command);
				String studentIdString=request.getParameter("studentId");
				int studentId= Integer.parseInt(studentIdString);
				
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				
				String studentFName=request.getParameter("studentFName");
				String studentLName=request.getParameter("studentLName");
				
				
				out.print("studentFName : "+studentFName);
				out.print("studentLName : "+studentLName);
				
				StudentBean studentBean=new StudentBean();
				
				studentBean.setStudentFirstName(studentFName);
				studentBean.setStudentLastName(studentLName);
				studentBean.setClassId(classId);
				studentBean.setStudentId(studentId);
				
				boolean updateStatus=adminService.updateStudent(studentBean);
				
				out.print("updateStatus : "+updateStatus);
				
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
			
			if(command.equals("DELETESTUDENT"))
			{
				String studentIdString=request.getParameter("studentId");
				int studentId= Integer.parseInt(studentIdString);
				
				//out.print("classId method > "+classId);
				int deleteStatus=0;
				
				try 
				{
					deleteStatus= adminService.deleteStudent(studentId);
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
			
			
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
