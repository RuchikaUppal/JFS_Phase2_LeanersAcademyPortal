<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
AdminService service=new AdminService();
List<ClassBean> classList = service.viewClasses();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Add New Student</h3>
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
			<td>First Name</td>
			<td><input type="text"  name="studentFName"></td>	
        </tr>
        <tr>
			<td>Last Name</td>
			<td><input type="text"  name="studentLName"></td>	
        </tr>
        <tr>
			<td>Class</td>
			<td><select name="classId">
			<%
			for (int i = 0; i < classList.size(); i++) 
			{
			%>
			<option value="<%=classList.get(i).getClassId()%>" selected><%=classList.get(i).getClassName()%>    <%=classList.get(i).getSection()%></option>
        	<%
			}
        	%>
    		</select></td>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Submit"></th>	
			<input type="hidden" name="command" value="ADDSTUDENT" />
        </tr>
        </table>
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>