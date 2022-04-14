<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.bean.StudentBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String studentIdString=request.getParameter("studentId").toString();
int studentId= Integer.parseInt(studentIdString);


//out.print("ClassId : " + classId);
AdminService service=new AdminService();
StudentBean studentBean=service.viewStudentById(studentId);

ClassBean classBean=service.viewClasseById(studentBean.getClassId());


					
%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Student Details</h3>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<form action="StudentServlet" method="GET">  
        <div class="container"> 
        <div id="content">  
        <table>
        <tr>
			<td>Student Id</td>
			<td><%=studentBean.getStudentId()%></td>	
			<input type="hidden" name="studentId" value="<%=studentBean.getStudentId()%>" />	
        </tr>
			
        <tr>
			<td>First Name</td>
			<td><%=studentBean.getStudentFirstName()%></td>
        </tr>
        <tr>
			<td>Last Name</td>
			<td><%=studentBean.getStudentLastName()%></td>	
        </tr>
        <tr>
			<td>Class</td>
			<td><%=classBean.getClassName()%></td>	
        </tr>
        <tr>
			<td>Section</td>
			<td><%=classBean.getSection()%></td>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Delete" value="Delete"></th>	
			<input type="hidden" name="command" value="DELETESTUDENT" />
        </tr>
        </table>

        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>