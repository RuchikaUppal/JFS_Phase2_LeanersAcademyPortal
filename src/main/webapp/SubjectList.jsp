<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.learnersacademy.admin.bean.SubjectsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Subjects</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">

<%

List<SubjectsBean> subjectList = (List<SubjectsBean>) request.getAttribute("SubjectList");
//HttpSession session=request.getSession();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />


		<div id="wrapper">

			<div id="header">
				<h3>List of Subjects</h3>
			</div>
		</div>
		<div id="container">
			<div id="content">
			<table>
				<tr>
					<th>Subject ID</th>
					<th>Subject Name</th>
					<th>Action</th>		
				</tr>
				<%
				//for(ClassBean classBean : classList){
				for (int i = 0; i < subjectList.size(); i++) 
				{
				%>
				
					<tr>
						<td><%=subjectList.get(i).getSubjectId()%></td>
						<td><%=subjectList.get(i).getSubjectName()%></td>
						<td><a href="UpdateSubject.jsp?subjectId=<%=subjectList.get(i).getSubjectId() %>">Update</a>
							<a href="DeleteSubject.jsp?subjectId=<%=subjectList.get(i).getSubjectId()%>">Delete</a>
						</td>
					</tr>
				<%
					} 
				%>
				</table>
				<div id="container">
					<div id="content">
						<table>
							<tr><td><a href="AddSubject.jsp">Add New Subject</a></td></tr>
						</table>
					</div>
				</div>
		
			</div>
		</div>
	</div>

</body>
</html>