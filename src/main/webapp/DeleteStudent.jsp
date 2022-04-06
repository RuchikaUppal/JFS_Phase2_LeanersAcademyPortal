<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.bean.StudentBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Class</title>
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
			<th>Student Id</th>
			<th><%=studentBean.getStudentId()%></th>	
			<input type="hidden" name="studentId" value="<%=studentBean.getStudentId()%>" />	
        </tr>
			
        <tr>
			<th>First Name</th>
			<th><%=studentBean.getStudentFirstName()%></th>
        </tr>
        <tr>
			<th>Last Name</th>
			<th><%=studentBean.getStudentLastName()%></th>	
        </tr>
        <tr>
			<th>Class</th>
			<th><%=classBean.getClassName()%></th>	
        </tr>
        <tr>
			<th>Section</th>
			<th><%=classBean.getSection()%></th>	
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