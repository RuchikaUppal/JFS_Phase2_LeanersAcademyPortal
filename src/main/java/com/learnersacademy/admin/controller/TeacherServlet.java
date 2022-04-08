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

import com.learnersacademy.admin.bean.ClassSubjectBean;
import com.learnersacademy.admin.bean.TeacherBean;
import com.learnersacademy.admin.bean.TeacherSubjectClassBean;
import com.learnersacademy.admin.service.AdminService;

/**
 * Servlet implementation class SubjectServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String command = request.getParameter("command");
			
			AdminService adminService=new AdminService();
			
			if(command.equals("TEACHERS"))
			{
				List<TeacherBean> teacherList=adminService.viewTeachers();
				
				if(teacherList!=null) 
				{ 
				  request.setAttribute("TeacherList", teacherList);
				  RequestDispatcher rd=request.getRequestDispatcher("/TeacherList.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				 
			}
			
			if(command.equals("ADDTEACHER"))
			{
				String teacherFName=request.getParameter("teacherFName");
				String teacherLName=request.getParameter("teacherLName");
				TeacherBean teacherBean=new TeacherBean();

				teacherBean.setTeacherFirstName(teacherFName);
				teacherBean.setTeacherLastName(teacherLName);
			
				boolean saveStatus=adminService.saveTeacher(teacherBean);
				
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
			
			if(command.equals("UPDATETEACHER"))
			{
				String teacherIdString=request.getParameter("teacherId");
				int teacherId= Integer.parseInt(teacherIdString);
				String teacherFName=request.getParameter("teacherFName");
				String teacherLName=request.getParameter("teacherLName");
				
				TeacherBean teacherBean=new TeacherBean();
				
				teacherBean.setTeacherFirstName(teacherFName);
				teacherBean.setTeacherLastName(teacherLName);
				teacherBean.setTeacherId(teacherId);
				
				boolean updateStatus=adminService.updateTeacher(teacherBean);
				
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
			
			if(command.equals("DELETETEACHER"))
			{
				String teacherIdString=request.getParameter("teacherId");
				int teacherId= Integer.parseInt(teacherIdString);
				
				//PrintWriter out=response.getWriter();
				//out.print("subId method > "+subjectId);
				int deleteStatus=0;
				
				try 
				{
					deleteStatus= adminService.deleteTeacher(teacherId);
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
			
			if(command.equals("ASSIGNCLASSTOTEACHER"))
			{
				String classIdString=request.getParameter("classIdAssigned");
				int classId= Integer.parseInt(classIdString);
				
				String teacherIdString=request.getParameter("teacherId").toString();
				int teacherId= Integer.parseInt(teacherIdString);
				
				request.setAttribute("teacherId", teacherId);
				request.setAttribute("classId", classId);
				RequestDispatcher rd=request.getRequestDispatcher("/AssignSubToTeacher.jsp");
				rd.forward(request,response);
				
			}
			
			if(command.equals("ASSIGNSUBTOTEACHER"))
			{
				String subIdNotAssignedString=request.getParameter("subIdNotAssigned");
				int subIdNotAssigned=0;
				
				if(subIdNotAssignedString!=null)
				{
					subIdNotAssigned= Integer.parseInt(subIdNotAssignedString);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Fail.jsp");
					rd.forward(request,response);
				}
				
				
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				
				String teacherIdString=request.getParameter("teacherId");
				int teacherId= Integer.parseInt(teacherIdString);
				
				TeacherSubjectClassBean bean=new TeacherSubjectClassBean();
				bean.setClassId(classId);
				bean.setSubId(subIdNotAssigned);
				bean.setTeacherId(teacherId);
				
				boolean saveStatus=adminService.saveTeacherClassSubject(bean);
				
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
	

	
