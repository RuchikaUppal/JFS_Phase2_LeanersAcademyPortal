<%@page import="java.io.PrintWriter"%>
<%@page import="com.learnersacademy.admin.bean.SubjectsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.learnersacademy.admin.bean.ClassBean"%>
<%@page import="com.learnersacademy.admin.service.AdminService"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subjects to Class</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<%
String classIdString=request.getParameter("classId").toString();
int classId= Integer.parseInt(classIdString);

AdminService service=new AdminService();
ClassBean classBean=service.viewClasseById(classId);

List<SubjectsBean> subNotInClassList = service.viewSubjectsNotInClass(classId);
List<SubjectsBean> subInClassList = service.viewSubjectsInClass(classId);

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
			<td><%=classBean.getClassName()%></td>	
        </tr>
        <tr>
			<td>Section</td>
			<td><%=classBean.getSection()%></td>
			
        </tr>
        <tr>
			<td>Subjects Assigned</td>
			<td>
			<%
			if (subInClassList.size()!=0)
			{
				for (SubjectsBean subjectBean :subInClassList ) 
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
			</td>	
			
        </tr>
        <tr>
			<td>Subject To Be Assigned</td>
			<td><select name="subIdNotAssigned">
			<%
			for (int i = 0; i <subNotInClassList.size(); i++) 
			{
			%>
				<option value="<%=subNotInClassList.get(i).getSubjectId()%>"><%=subNotInClassList.get(i).getSubjectName()%></option>
        	<%
			}
        	%>
    		</select></td>	
			
        </tr>
        </table>
        <table>
        <tr>
			<th align="center"><input type="submit"  name="Assign" value="Assign"></th>	
			<input type="hidden" name="command" value="ASSIGNSUBTOCLASS" />
        </tr>
        </table>
        
        	          
        </div> 
         </div>   
    </form> 
	</div>

</body>
</html>