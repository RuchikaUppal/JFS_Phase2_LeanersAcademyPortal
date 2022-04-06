<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Add New Class</h3>
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
			<th>Class Name</th>
			<th><input type="text"  name="className"></th>	
        </tr>
        <tr>
			<th>Section</th>
			<th><input type="text"  name="section"></th>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Submit"></th>	
			<input type="hidden" name="command" value="ADDCLASS" />
        </tr>
        </table>
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>