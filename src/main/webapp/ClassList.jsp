<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.learnersacademy.admin.bean.ClassBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Classes</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">

<%

List<ClassBean> classList = (List<ClassBean>) request.getAttribute("ClassList");
//HttpSession session=request.getSession();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />


		<div id="wrapper">

			<div id="header">
				<h3>List of Classes</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<table>
				<tr>
					<th>Class ID</th>
					<th>Class Name</th>
					<th>Section</th>
					<th>Action</th>	
					<th>Assign Subjects</th>
						
				</tr>
				<%
				//for(ClassBean classBean : classList){
				for (int i = 0; i < classList.size(); i++) 
				{
				%>
				
					<tr>
						<td><%=classList.get(i).getClassId()%></td>
						<td><%=classList.get(i).getClassName()%></td>
						<td><%=classList.get(i).getSection()%></td>
						<td><a href="UpdateClass.jsp?classId=<%=classList.get(i).getClassId() %>">Update</a>
							<a href="DeleteClass.jsp?classId=<%=classList.get(i).getClassId()%>">Delete</a>
						</td>
						<td><a href="AssignSubjectsToClass.jsp?classId=<%=classList.get(i).getClassId() %>">Assign</a>
						</td>
					</tr>
				<%
					} 
				%>
				</table>
				<div id="container">
					<div id="content">
						<table>
							<tr><td><a href="AddClass.jsp">Add New Class</a></td></tr>
						</table>
					</div>
				</div>
		
			</div>
		</div>
	</div>

</body>
</html>