<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="getemployee" modelAttribute="employeeget">

		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<br>
		<br>
		<form:label path="pass">Password</form:label>
		<form:input path="pass" />
		<br>
		<br>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>