<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.learnersacademy.admin.bean.StudentBean"%>
<%@ page import="com.learnersacademy.admin.bean.TeacherBean"%>
<%@ page import="com.learnersacademy.admin.bean.SubjectsBean"%>
<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
<link type="text/css" rel="stylesheet" href="css/styleNew.css">
</head>

<body style="background-image: url('css/background.jpg');">
<form action="ClassReportServlet" method="GET">
<%

List<StudentBean> studentList = (List<StudentBean>) request.getAttribute("StudentList");
List<TeacherBean> teacherList = (List<TeacherBean>) request.getAttribute("TeacherList");
List<SubjectsBean> subjectList = (List<SubjectsBean>) request.getAttribute("SubjectList");

String classIdString=request.getParameter("classId").toString();
int classId= Integer.parseInt(classIdString);

AdminService service=new AdminService();
ClassBean classBean=service.viewClasseById(classId);


%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />


		<div id="wrapper">
			<div id="header">
				<h3>Class Details</h3>
			</div>
		</div>
		
		<div id="container">
		<div id="content">
		<table>
			<tr><th>Students enrolled for the Class <%=classBean.getClassName()%>  <%=classBean.getSection()%></th></tr>
		</table>
		</div>
		</div>
		
		<div id="container">
			<div id="content">
			<table>
			<%
			if(studentList.size()>0)
			{
			%>
				<tr>
					<td><b>Student Id</b></td>
					<td><b>First Name</b></td>
					<td><b>Last Name</b></td>
				</tr>
			<%
			}
			else
			{	
			%>
				<tr><td><b>No Students Enrolled for the Class</b></tr></td>
			<%
			}
			%>
			<%
			for(StudentBean studentBean : studentList)
			{
				
			%>
				<tr>
					<td><%=studentBean.getStudentId()%></td>
					<td><%=studentBean.getStudentFirstName()%></td>
					<td><%=studentBean.getStudentLastName()%></td>
				</tr>
			<%
			} 
			%>
			</table>
			</div>
		</div>
				
		<div id="container">
		<div id="content">
		<table>
			<tr><th>Subjects assigned for the Class <%=classBean.getClassName()%>  <%=classBean.getSection()%></th></tr>
		</table>
		</div>
		</div>	
		
		<div id="container">
			<div id="content">	
			<table>	
			<%
			if(subjectList.size()>0)
			{
			%>
				<tr>
					<td><b>Subject Id</b></td>
					<td><b>Subject Name</b></td>
				</tr>
			<%
			}
			else
			{	
			%>
				<tr><td><b>No Subjects Assigned for the Class</b></tr></td>
			<%
			}
			%>
			<%
			for(SubjectsBean subjectBean : subjectList){
			
			%>
			
				<tr>
					<td><%=subjectBean.getSubjectId()%></td>
					<td><%=subjectBean.getSubjectName()%></td>
				</tr>
			<%
				} 
			%>
			</table>
			</div>
		</div>	
		
		<div id="container">
		<div id="content">
		<table>
			<tr><th>Teachers assigned for the Class <%=classBean.getClassName()%>  <%=classBean.getSection()%></th></tr>
		</table>
		</div>
		</div>	
		
		<div id="container">
		<div id="content">
			<table>
			<%
			if(teacherList.size()>0)
			{
			%>
				<tr>
					<td><b>Teacher Id</b></td>
					<td><b>First Name</b></td>
					<td><b>Last Name</b></td>
					<td><b>Subjects Assigned</b></td>
				</tr>
			<%
			}
			else
			{	
			%>
				<tr><td><b>No Teachers Assigned for the Class</b></tr></td>
			<%
			}
			%>
			<%
			for(TeacherBean teacherBean : teacherList)
			{		
			%>
				<tr>
					<td><%=teacherBean.getTeacherId()%></td>
					<td><%=teacherBean.getTeacherFirstName()%></td>
					<td><%=teacherBean.getTeacherLastName()%></td>
					<td>
				
			<%
				List<SubjectsBean> subjectListByTeacherId=service.viewSubjectsAssignedToTeacher(classId, teacherBean.getTeacherId());
				for(SubjectsBean subBean : subjectListByTeacherId)
				{
				%>
					
					<%=subBean.getSubjectName()%>
				
				<%	
				}
				%>
				</td>
				</tr>
			<%	
			} 
			%>
			</table>
		</div>
		</div>
		<table>
        <tr>
			<th align="center"><input type="submit"  name="Back" Value="Back"></th>	
			<input type="hidden" name="command" value="CLASSREPORT" />
        </tr>
        
        </table>
</div>
</form> 
</body>
</html>