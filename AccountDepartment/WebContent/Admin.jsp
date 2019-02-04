<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-color: lightblue;
	margin-left: 300px;
	font-family: "Verdana";
	
}
a{
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
WELCOME ADMIN : 	<%= request.getAttribute("user")%> <br> <br>

	
	<a href=./ReportsController?name=report1>Report 1</a> <br>
	<a href=./ReportsController?name=report2>Report 2</a> <br>
	<a href=./ReportsController?name=report3>Report 3</a> <br>
	
	<form action="./AdminController" method="post">
		<input type="submit" value="Reset">
	</form>
</body>
</html>