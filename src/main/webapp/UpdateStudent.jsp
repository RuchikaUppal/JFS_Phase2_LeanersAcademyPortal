<%@page import="java.util.List"%>
<%@page import="com.learnersacademy.admin.bean.StudentBean"%>
<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String studentIdString=request.getParameter("studentId").toString();
int studentId= Integer.parseInt(studentIdString);

AdminService service=new AdminService();
StudentBean studentBean=service.viewStudentById(studentId);
List<ClassBean> classList = service.viewClasses();



					
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
			<td>Class Id</td>
			<td><%=studentBean.getStudentId()%></td>
			<input type="hidden" name="studentId" value="<%=studentBean.getStudentId()%>" />	
        </tr>
			
        <tr>
			<td>First Name</td>
			<td><input type="text"  name="studentFName" value= "<%=studentBean.getStudentFirstName()%>"></td>	
        </tr>
        <tr>
			<td>Last Name</td>
			<td><input type="text"  name="studentLName" value= "<%=studentBean.getStudentLastName()%>"></td>
			
        </tr>
        <tr>
			<td>Class</td>
			<td><select name="classId">
			<%
			for (int i = 0; i < classList.size(); i++) 
			{
			%>
			<option value="<%=classList.get(i).getClassId()%>"><%=classList.get(i).getClassName()%>    <%=classList.get(i).getSection()%></option>
        	<%
			}
        	%>
    		</select></td>	
			
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Update" value="Update"></th>	
			<input type="hidden" name="command" value="UPDATESTUDENT" />
        </tr>
        </table>
        
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>