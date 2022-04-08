<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav">
	<h3 id="logo">Menu</h3>
	<c:url var="classesLink" value="ClassServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="SubjectServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="TeacherServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="StudentServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	<c:url var="classReport" value="ClassReportServlet">
		<c:param name="command" value="CLASSREPORT" />
	</c:url>
	
	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="${classReport}">Class Report</a>
		<a class="bar-item" href="AdminLogin.jsp">Log out</a>

</div>

