<%@ page import="com.bean.Report2"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

th {
	text-align: left;
	background-color: #4CAF50;
	color: white;
	padding-top: 12px;
	padding-bottom: 12px;
}

table {
	width: 80%;
	border-collapse: collapse;
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	WECOME TO REPORT 2
	<br>
	<br>

	<table border=1>
		<tr>
			<th>ASSOCIATE</th>
			<th>REWARD_GIVEN</th>
			
			
		</tr>
		<% 
	
	ArrayList<Report2> reports2 =(ArrayList<Report2>) request.getAttribute("reports2");
	// request.getSession().setAttribute("sender", report); 
	for(Report2 report : reports2){
	%>

		<tr> 
		<td><% out.println(report.getEmpId()); %></td>
		<td><% out.println(report.getStatusMessage()); %></td>
		</tr>
	<%
	} 
	%>
	</table>

</body>
</html>