<%@ page import="com.bean.User" %>
<%@ page import="java.util.ArrayList" %>
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
     text-align: center;
}
p{

	
	 font-size: 40px;
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer page</title>
</head>
<body>
	
	Welcome  <%= request.getAttribute("senderName") %>   to Transfer page!!! :)
<br><br><br>
	<form action="./TransferFinal" method="post">
	<% 
	User sender =(User) request.getAttribute("sender");
	ArrayList<User> users =(ArrayList<User>) request.getAttribute("users");
	request.getSession().setAttribute("sender", sender); 
	%>
		<table>
			<tr>
				<td>To :</td>
				<td><select id="to_user" name="to_user">
				<% for(User user : users){ 
						if(!sender.getEmployeeId().equals(user.getEmployeeId()) &&  "N".equals(user.getAdmin())){
				%>
					
					<option value="<% out.println(user.getEmployeeId()); %>"><%out.println(user.getUserName()); %></option>
				
				<%	}} %>
					
				
						
				</select></td>
			<tr>
				<td>Amount :</td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td>Message:</td>
				<td><input type="text" name="message"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>