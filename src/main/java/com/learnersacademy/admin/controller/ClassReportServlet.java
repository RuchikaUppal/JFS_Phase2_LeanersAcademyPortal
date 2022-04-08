package com.learnersacademy.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.bean.ClassBean;
import com.learnersacademy.admin.bean.StudentBean;
import com.learnersacademy.admin.bean.SubjectsBean;
import com.learnersacademy.admin.bean.TeacherBean;
import com.learnersacademy.admin.service.AdminService;

/**
 * Servlet implementation class ClassReportServlet
 */
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			String command = request.getParameter("command");
			
			AdminService adminService=new AdminService();
			
			if(command.equals("CLASSREPORT"))
			{
				List<ClassBean> classList=adminService.viewClasses();
				
				if(classList!=null) 
				{ 
				  request.setAttribute("ClassList", classList);
				  RequestDispatcher rd=request.getRequestDispatcher("/ClassReport.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				 
			}
			if(command.equals("CLASSIDREPORT"))
			{
				String classIdString=request.getParameter("classId");
				int classId= Integer.parseInt(classIdString);
				
				List<StudentBean> studentList= adminService.viewStudentsByClassId(classId);
				List<SubjectsBean> subjectList=adminService.viewSubjectsInClass(classId);
				List<TeacherBean> teacherList =adminService.viewAllTeachersByClassId(classId);
				
				if(studentList!=null || subjectList!=null || teacherList!=null) 
				{ 
				  request.setAttribute("StudentList", studentList);
				  request.setAttribute("SubjectList", subjectList);
				  request.setAttribute("TeacherList", teacherList);
				  request.setAttribute("ClassId", classId);
				  
				  RequestDispatcher rd=request.getRequestDispatcher("/ClassIdReport.jsp");
				  rd.forward(request,response);
				}
				  
				else 
				{ 
					 RequestDispatcher rd=request.getRequestDispatcher("/NoData.jsp");
					 rd.forward(request,response); 
				}
				
				//List<SubjectsBean> subjectBeanByTeacherId=adminService.viewSubjectsAssignedToTeacher(classId, classId)
			}
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	
}
