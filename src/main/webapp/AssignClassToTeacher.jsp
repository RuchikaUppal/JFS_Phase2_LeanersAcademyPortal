<%@page import="java.io.PrintWriter"%>
<%@page import="com.learnersacademy.admin.bean.SubjectsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.bean.TeacherBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Class to Teacher</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String teacherIdString=request.getParameter("teacherId").toString();
int teacherId= Integer.parseInt(teacherIdString);


AdminService service=new AdminService();
TeacherBean teacherBean=service.viewTeacherById(teacherId);

List<ClassBean> classList = service.viewClasses();
//List<ClassBean> classNotAssignedToTeacherList = service.viewClassesNotAssigendToTeacher(teacherId);
//List<ClassBean> classAssignedToTeacherList = service.viewClassesAssigendToTeacher(teacherId);

/* out.print("subInClassList above :"+subInClassList.size());
for(SubjectsBean subjectbean:subInClassList )
{
	out.print("sub id above :"+subjectbean.getSubjectId());
	out.print("sub name above :"+subjectbean.getSubjectName());
}
 */
					
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
			<td>Teacher Id</td>
			<td><%=teacherBean.getTeacherId()%></td>
			<input type="hidden" name="teacherId" value="<%=teacherBean.getTeacherId()%>" />
        </tr>
			
        <tr>
			<td>First Name</td>
			<td><%=teacherBean.getTeacherFirstName()%></td>	
        </tr>
        <tr>
			<td>Last Name</td>
			<td><%=teacherBean.getTeacherLastName()%></td>
			
        </tr>
    
        <tr>
			<td>Select Class</td>
			<td><select name="classIdAssigned">
			<%
			for (int i = 0; i <classList.size(); i++) 
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
			<th align="center"><input type="submit"  name="Assign" value="Assign"></th>	
			<input type="hidden" name="command" value="ASSIGNCLASSTOTEACHER" />
        </tr>
        </table>
        
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>