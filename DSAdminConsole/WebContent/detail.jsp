<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User account = (User) session.getAttribute("account");
	ArrayList<Statistica> stats = (ArrayList<Statistica>) session.getAttribute("stats");
	String message = (String) request.getAttribute("invalid");
	ArrayList<String> details = (ArrayList<String>) session.getAttribute("details");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,java.sql.*,logic.*"%>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>DSAdminConsole</title>
<%@ include file="/head.jsp"%>
</head>
<body>
	<%
		if (account == null) {
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<%@ include file="/navbar.jsp"%>
	
	<label><%= stats.get(0).getFileContent() %></label>

</body>
</html>