<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User account = (User) session.getAttribute("account");
	ArrayList<Statistica> stats = (ArrayList<Statistica>) session.getAttribute("stats");
	String message = (String) request.getAttribute("invalid");
	String details = (String) session.getAttribute("detail");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.io.*,java.util.*,java.sql.*,logic.*"%>
<head>
<meta charset="utf-8">
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

	<div class="container">
		<%
			File file = new File("C:\\Users\\alfon\\OneDrive\\Desktop\\Tesi\\GitDsa\\" + details);
			if (file.exists()) {
				Scanner sc = new Scanner(file, "UTF-8");

				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.contains("error:")) {
		%>
		<div class="row bg-danger" id="row">
			<p class="error"><%=line%></p>
		</div>
		<%
			} else if (line.contains("frase scritta:")) {
		%>
		<div class="row bg-success" id="row">
			<p class="error"><%=line%></p>
		</div>
		<%
			} else if (line.contains("saltata")) {
		%>
		<div class="row bg-warning" id="row">
			<p class="error"><%=line%></p>
		</div>
		<%
			} else {
		%>
		<div class="row" id="row">
			<p class="error"><%=line%></p>
		</div>
		<%
			}
				}
			}else{
		%>
		<div class="row bg-danger" id="row">
			<label>Il dettaglio del test non è disponibile contattare l'assistenza</label>
		</div>
		<%} %>
	</div>
	<div class="">
		<a href="home.jsp"><input type="button" class="input1"
			value="Chiudi" /></a>
	</div>
</body>
</html>