<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Class</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String classIdString=request.getParameter("classId").toString();
int classId= Integer.parseInt(classIdString);
//out.print("ClassId : " + classId);
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
		<br>
		<br>
		<br>
		<br>
		<br>
		<form action="ClassServlet" method="GET">  
        <div class="container"> 
        <div id="content">  
        <table>
         <tr>
			<td>Class Id</td>
			<td><%=classBean.getClassId()%></td>
			<input type="hidden" name="classId" value="<%=classBean.getClassId()%>" />	
        </tr>
			
        <tr>
			<td>Class Name</td>
			<td><input type="text"  name="className" value= "<%=classBean.getClassName()%>"></td>	
        </tr>
        <tr>
			<td>Section</td>
			<td><input type="text"  name="section" value= "<%=classBean.getSection()%>"></td>
			
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Update" value="Update"></th>	
			<input type="hidden" name="command" value="UPDATECLASS" />
        </tr>
        </table>
        
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>