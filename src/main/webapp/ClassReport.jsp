<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">

<%

List<ClassBean> classList = (List<ClassBean>) request.getAttribute("ClassList");
AdminService service=new AdminService();

%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Select a Class to view report</h3>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<form action="ClassReportServlet" method="GET">  
        <div class="container"> 
        <div id="content">  
        <table>
			
        <tr>
			<th>Select Class</th>
			<th><select name="classId">
			<%
			for (int i = 0; i <classList.size(); i++) 
			{
			%>
				<option value="<%=classList.get(i).getClassId()%>"><%=classList.get(i).getClassName()%>  <%=classList.get(i).getSection()%></option>
        	<%
			}
        	%>
    		</select></th>		
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Submit"></th>	
			<input type="hidden" name="command" value="CLASSIDREPORT" />
        </tr>
        
        </table>
        	          
        </div> 
         </div>   
    </form> 
	</div>
</body>
</html>