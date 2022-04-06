<%@page import="com.learnersacademy.admin.bean.TeacherBean"%>
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
String teacherIdString=request.getParameter("teacherId").toString();
int teacherId= Integer.parseInt(teacherIdString);
//out.print("ClassId : " + classId);
AdminService service=new AdminService();
TeacherBean teacherBean=service.viewTeacherById(teacherId);

					
%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Teacher Details</h3>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<form action="TeacherServlet" method="GET">  
        <div class="container"> 
        <div id="content">  
        <table>
        <tr>
			<th>Teacher Id</th>
			<th><%=teacherBean.getTeacherId()%></th>
			<input type="hidden" name="teacherId" value="<%=teacherBean.getTeacherId()%>" />	
        </tr>
			
        <tr>
			<th>First Name</th>
			<th><%=teacherBean.getTeacherFirstName()%></th>	
        </tr>
        <tr>
			<th>Last Name </th>
			<th><%=teacherBean.getTeacherLastName()%></th>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Delete" value="Delete"></th>	
			<input type="hidden" name="command" value="DELETETEACHER" />
        </tr>
        </table>

        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>