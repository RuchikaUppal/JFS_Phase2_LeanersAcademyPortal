<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.learnersacademy.admin.bean.TeacherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">

<%

List<TeacherBean> teacherList = (List<TeacherBean>) request.getAttribute("TeacherList");
//HttpSession session=request.getSession();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />


		<div id="wrapper">

			<div id="header">
				<h3>List of Teachers</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<table>
				<tr>
					<th>Teacher ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Action</th>	
					<th>Assign Classes and Subjects</th>		
				</tr>
				<%
				
				for (int i = 0; i < teacherList.size(); i++) 
				{
				%>
				
					<tr>
						<th><%=teacherList.get(i).getTeacherId()%></th>
						<th><%=teacherList.get(i).getTeacherFirstName()%></th>
						<th><%=teacherList.get(i).getTeacherLastName()%></th>
						<th><a href="UpdateTeacher.jsp?teacherId=<%=teacherList.get(i).getTeacherId() %>">Update</a>
							<a href="DeleteTeacher.jsp?teacherId=<%=teacherList.get(i).getTeacherId()%>">Delete</a>
						</th>
						<th><a href="AssignClassAndSubToTeacher.jsp?teacherId=<%=teacherList.get(i).getTeacherId() %>">Assign</a>
					</tr>
				<%
					} 
				%>
				</table>
				<div id="container">
					<div id="content">
						<table>
							<tr><th><a href="AddTeacher.jsp">Add New Teacher</a></th></tr>
						</table>
					</div>
				</div>
		
			</div>
		</div>
	</div>

</body>
</html>