<%@page import="com.learnersacademy.admin.bean.SubjectsBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Subject</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String subjectIdString=request.getParameter("subjectId").toString();
int subjectId= Integer.parseInt(subjectIdString);
//out.print("ClassId : " + classId);
AdminService service=new AdminService();
SubjectsBean subjectBean=service.viewSubjectById(subjectId);

					
%>
	 <div id="page">
		<jsp:include page="Menu.jsp" />
		<div id="wrapper">
			<div id="header">
				<h3>Subject Details</h3>
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
			<th>Subject Id</th>
			<th><%=subjectBean.getSubjectId()%></th>
			<input type="hidden" name="subjectId" value="<%=subjectBean.getSubjectId()%>" />	
        </tr>
			
        <tr>
			<th>Subject Name</th>
			<th><%=subjectBean.getSubjectName()%></th>	
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Delete" value="Delete"></th>	
			<input type="hidden" name="command" value="DELETESUBJECT" />
        </tr>
        </table>

        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>