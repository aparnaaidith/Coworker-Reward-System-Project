<%@ page import="com.bean.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style type="text/css">
body {
    background-color: lightblue;
    margin-left: 300px;
    font-family: "Verdana";
     text-align: center;
}
p{

	
	 font-size: 40px;
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="./TransferServlet" method="post">
	<%
	User user = (User)request.getAttribute("user");
	String username = user.getUserName();
	//String user1 =(String) request.getAttribute("user");
	request.getSession().setAttribute("user1", user);
	out.println("Welcome " + username);
	%>
		<table>
			<tr>
				
				<td>  !! What do you want ? Please choose one of the option
				
				</td>			
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Transfer">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Redeem">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>