<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@ page import="com.learnersacademy.admin.bean.StudentBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">

<%

List<StudentBean> studentList = (List<StudentBean>) request.getAttribute("StudentList");
AdminService service=new AdminService();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />


		<div id="wrapper">

			<div id="header">
				<h3>List of Students</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<table>
				<tr>
					<th>Student ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Class</th>
					<th>Section</th>
					<th>Action</th>		
				</tr>
				<%
				//for(ClassBean classBean : classList){
				for (int i = 0; i < studentList.size(); i++) 
				{
					ClassBean classBean=service.viewClasseById(studentList.get(i).getClassId());
				
				%>
				
					<tr>
						<th><%=studentList.get(i).getStudentId()%></th>
						<th><%=studentList.get(i).getStudentFirstName()%></th>
						<th><%=studentList.get(i).getStudentLastName()%></th>
						<th><%=classBean.getClassName()%></th>
						<th><%=classBean.getSection()%></th>
						<th><a href="UpdateStudent.jsp?studentId=<%=studentList.get(i).getStudentId() %>">Update</a>
							<a href="DeleteStudent.jsp?studentId=<%=studentList.get(i).getStudentId()%>">Delete</a>
						</th>
					</tr>
				<%
					} 
				%>
				</table>
				<div id="container">
					<div id="content">
						<table>
							<tr><th><a href="AddStudent.jsp">Add New Student</a></th></tr>
						</table>
					</div>
				</div>
		
			</div>
		</div>
	</div>

</body>
</html>