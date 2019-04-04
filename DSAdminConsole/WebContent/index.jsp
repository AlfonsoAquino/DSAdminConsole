<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User account = (User) session.getAttribute("account");
	String message = (String) request.getAttribute("invalid");
%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,java.sql.*,logic.*"%>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>DSAdminConsole</title>
<%@ include file="/head.jsp" %>

</head>
<body>
<%
		if (account != null) {
			response.sendRedirect("home.jsp");
			return;
		}

	%>
	<div class="wrapper">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="first">
				<img src="img/dsa_logo.png" id="icon" alt="DSA Game" />
				<h1>DSA Admin Console</h1>
			</div>

			<!-- Login Form -->
			<form action="LoginServ" method="post">
				<input type="text" id="login" class="input second" name="loginEmail"
					placeholder="Email" required> <input type="password"
					id="password" class="input third" name="loginPass"
					placeholder="Password" required>
				<%
					if (message != null) {
				%>
				<p style="color: red;"><%=message%></p>
				<%
					}
				%>
				<input type="submit" class="fourth" value="Log In">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<label>Non hai un account?</label> <a class="underlineHover"
					href="registrazione.jsp">Registrati!</a>
			</div>

		</div>
	</div>
</body>
</html>