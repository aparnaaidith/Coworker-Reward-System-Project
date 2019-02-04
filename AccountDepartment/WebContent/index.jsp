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


</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Login page</title>
</head>
<body>
	<form action=./MainController method="post">
		<p>Welcome to my application</p>
		
		<table>
			<tr>
				<td>Username :</td>
			</tr>
			<tr>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
			</tr>
			<tr>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>

	</form>

</body>
</html>