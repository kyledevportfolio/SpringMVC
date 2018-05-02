<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE STUDENT</title>
</head>
<body>
	<form action="http://localhost:8080/student/update" method="post">
		
		ID: <input type="text" name="id" value="${selectedstudent.id}" readonly style="border: none;">
		<br/>
		Name<br/>
		<input type="text" name="name" value="${selectedstudent.name}" />
		<br /> 
		Age<br/>
		<input type="text" name="age" value="${selectedstudent.age}"/>
		<br /><br />
		<button type="submit">Update student</button>
		<button><a href="http://localhost:8080/student/list" style="text-decoration: none;">Cancel</a></button>
	</form>
</body>
</html>