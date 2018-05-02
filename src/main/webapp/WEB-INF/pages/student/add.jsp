<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD STUDENT</title>
</head>
<body>
	<form action="http://localhost:8080/student/add" method="post">
		
		<h1>ADD STUDENT</h1>
		<input type="text" name="name" placeholder="Name" /><br/><br/>
		<input type="text" name="age" placeholder="Age"/><br/><br/>

		<button type="submit">ADD STUDENT</button><br/><br/>
	</form>
	
	<form method="post" action="http://localhost:8080/student/search">
		<input type="text" name="txtsearch" placeholder="Search Student">
		<button type="submit">Search</button>
	</form>
	
	<form method="post" action="http://localhost:8080/student/delete">
	<br/>
		<c:forEach items="${studentList}" var="studentVar">
			<input type="checkbox" name="id" value="${studentVar.id}">
			Name: <a href="http://localhost:8080/student/update?id=${studentVar.id}">${studentVar.name}</a> Age: ${studentVar.age}<br/>
		</c:forEach>
		<br/>
		<button type="submit">Delete student/s</button>
	</form>
</body>
</html>