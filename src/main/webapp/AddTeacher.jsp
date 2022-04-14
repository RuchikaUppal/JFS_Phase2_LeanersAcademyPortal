<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Add New Teacher</h3>
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
			<td>First Name</td>
			<td><input type="text"  name="teacherFName"></td>	
        </tr>
        <tr>
			<td>Last Name</td>
			<td><input type="text"  name="teacherLName"></td>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Submit"></th>	
			<input type="hidden" name="command" value="ADDTEACHER" />
        </tr>
        </table>
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>