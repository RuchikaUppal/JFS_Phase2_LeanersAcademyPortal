<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Add New Subject</h3>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<form action="SubjectServlet" method="GET">  
        <div class="container"> 
        <div id="content">  
        <table>
			
        <tr>
			<th>Subject Name</th>
			<th><input type="text"  name="subjectName"></th>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Submit"></th>	
			<input type="hidden" name="command" value="ADDSUBJECT" />
        </tr>
        
        </table>
        	          
        </div> 
         </div>   
    </form> 
	</div>
</body>
</html>