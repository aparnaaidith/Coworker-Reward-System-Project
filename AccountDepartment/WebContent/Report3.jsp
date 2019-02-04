<%@ page import="com.bean.Report3"%>
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
 
    text-align: center;
    background-color: #4CAF50;
    color: white;
    padding-top: 12px;
    padding-bottom: 12px;
}
td{
	padding-top: 12px;
	padding-bottom: 12px;
}
table {
    width: 80%;
    border-radius: 25px;
    border-collapse: collapse;
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
WECOME TO REPORT 3<br><br>
<table border=1>
	<tr>
		<th> EMPLOYEE ID   </th>
		<th> TOTAL_REDEMPTION  </th>
		<th> MONTH  </th>
		
	
	
	
	<% 
	
	ArrayList<Report3> reports3 =(ArrayList<Report3>) request.getAttribute("reports3");
	// request.getSession().setAttribute("sender", report); 
	for(Report3 report : reports3){
	%>	
	<tr> 
		<td><% out.println(report.getEmpId()); %></td>
		<td><% out.println(report.getTotalRedemption()); %></td>
		<td><% out.println(report.getMonth()); %>
		</tr>
	<%
	} 
	%>
	
</table>

</body>
</html>