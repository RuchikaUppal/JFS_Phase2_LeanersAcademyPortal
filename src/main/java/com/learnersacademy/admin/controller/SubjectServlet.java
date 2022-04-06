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

import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.service.AdminService;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String command = request.getParameter("command");
			
			AdminService adminService=new AdminService();
			
			if(command.equals("SUBJECTS"))
			{
				List<SubjectsBean> subjectList=adminService.viewSubjects();
				
				if(subjectList!=null) 
				{ 
				  request.setAttribute("SubjectList", subjectList);
				  RequestDispatcher rd=request.getRequestDispatcher("/SubjectList.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				 
			}
			
			if(command.equals("ADDSUBJECT"))
			{
				String subjectName=request.getParameter("subjectName");
				
				SubjectsBean subjectBean=new SubjectsBean();

				subjectBean.setSubjectName(subjectName);
			
				boolean saveStatus=adminService.saveSubject(subjectBean);
				
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
			
			if(command.equals("UPDATESUBJECT"))
			{
				String subjectIdString=request.getParameter("subjectId");
				int subjectId= Integer.parseInt(subjectIdString);
				String subjectName=request.getParameter("subjectName");
				
				SubjectsBean subjectBean=new SubjectsBean();
				
				subjectBean.setSubjectName(subjectName);
				subjectBean.setSubjectId(subjectId);
				
				boolean updateStatus=adminService.updateSubject(subjectBean);
				
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
			
			if(command.equals("DELETESUBJECT"))
			{
				String subjectIdString=request.getParameter("subjectId");
				int subjectId= Integer.parseInt(subjectIdString);
				
				PrintWriter out=response.getWriter();
				out.print("subId method > "+subjectId);
				int deleteStatus=0;
				
				try 
				{
					deleteStatus= adminService.deleteSubject(subjectId);
					out.print("deleteStatus method > "+deleteStatus);
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
	
