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
<title>Assign Subject</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String teacherIdString=request.getParameter("teacherId").toString();
int teacherId= Integer.parseInt(teacherIdString);

String classIdString=request.getParameter("classIdAssigned");
int classId= Integer.parseInt(classIdString);


AdminService service=new AdminService();
TeacherBean teacherBean=service.viewTeacherById(teacherId);
ClassBean classbean=service.viewClasseById(classId);

List<SubjectsBean> subNotAssined = service.viewSubjectsNotAssignedToTeacher(classId, teacherId);
List<SubjectsBean> subAssigned = service.viewSubjectsAssignedToTeacher(classId, teacherId);



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
			<th>Teacher Id</th>
			<th><%=teacherBean.getTeacherId()%></th>
			<input type="hidden" name="teacherId" value="<%=teacherBean.getTeacherId()%>" />
        </tr>
			
        <tr>
			<th>First Name</th>
			<th><%=teacherBean.getTeacherFirstName()%></th>	
        </tr>
        <tr>
			<th>Last Name</th>
			<th><%=teacherBean.getTeacherLastName()%></th>
			
        </tr>
        
        <tr>
			<th>Class Id</th>
			<th><%=classbean.getClassId()%></th>
			<input type="hidden" name="classId" value="<%=classbean.getClassId()%>" />
        </tr>
			
        <tr>
			<th>Class Name</th>
			<th><%=classbean.getClassName()%></th>	
        </tr>
        <tr>
			<th>Section</th>
			<th><%=classbean.getSection()%></th>
			
        </tr>
        <tr>
			<th>Subjects Assigned</th>
			<th>
			<%
			if (subAssigned.size()!=0)
			{
				for (SubjectsBean subjectBean :subAssigned ) 
				{
					
				%>
					<%=subjectBean.getSubjectName()%>
					
	        	<%
				}
			}
			else 
			{	
			%>
				No Subjects Assigned
			<%
			}
			%>
			</th>	
			
        </tr>
        <tr>
			<th>Subjects To Be Assigned</th>
			<th>
			<%
			if (subNotAssined.size()!=0)
			{
			%>
				<select name="subIdNotAssigned">
				<%	
				for (int i = 0; i <subNotAssined.size(); i++) 
				{
				%>
					<option value="<%=subNotAssined.get(i).getSubjectId()%>" selected><%=subNotAssined.get(i).getSubjectName()%></option>
	        	<%
				}
				%>
				</select>
				<%
			}
			else
			{
        	%>
				No Subjects Assigned for the Class 
			<%
			}
			%>
    		</th>	
			
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Assign" value="Assign"></th>	
			<input type="hidden" name="command" value="ASSIGNSUBTOTEACHER" />
        </tr>
        </table>
        
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>