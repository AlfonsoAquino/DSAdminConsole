<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User account = (User) session.getAttribute("account");
	ArrayList<?> stats = (ArrayList<?>) session.getAttribute("stats");
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

	<div class="table-responsive body-table">
		<table class="table">
			<caption>
				<h3>Risultati ricerca</h3>
			</caption>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Regione</th>
					<th scope="col">Codice plesso</th>
					<th scope="col">Codice classe</th>
					<th scope="col">Codice registro</th>
					<th scope="col">Tipo test</th>
					<th scope="col">Data</th>
					<th scope="col">Genere</th>
					<th scope="col">Età</th>
					<th scope="col">Num. Corrette</th>
					<th scope="col">Num. Sbagliate</th>
					<th scope="col">Num. saltate</th>
					<th scope="col">Livello max.</th>
					<th scope="col">Tempo</th>
					<th scope="col">Err. liv. 1</th>
					<th scope="col">Err. liv. 2</th>
					<th scope="col">Err. liv. 3</th>
					<th scope="col">Err. liv. 4</th>
					<th scope="col">Domanda 1</th>
					<th scope="col">Domanda 2</th>
					<th scope="col">Domanda 3</th>
					<th scope="col">Domanda 4</th>
					<th scope="col">Domanda 5</th>
					<th scope="col">Domanda 6</th>
					<th scope="col">Domanda 7</th>
					<th scope="col">Domanda 8</th>
					<th scope="col">Dettaglio test</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (message != null) {
				%>
				<tr class="bg-danger">
					<th scope="row">1</th>
					<td colspan="26"><p style="color: red;"><%=message%></p></td>
				</tr>
				<%
					} else if (stats != null && stats.size() != 0) {
						Iterator<?> it = stats.iterator();
						int i = 1;
						while (it.hasNext()) {
							Statistica p = (Statistica) it.next();
				%>
				<tr>
					<th scope="row"><%=i%></th>
					<td><%=p.getRegione()%></td>
					<td><%=p.getCodicePlesso()%></td>
					<td><%=p.getCodiceClasse()%></td>
					<td><%=p.getCodiceRegistro()%></td>
					<td><%=p.getTipoTest()%></td>
					<td><%=p.getData()%></td>
					<td><%=p.getGenere()%></td>
					<td><%=p.getEta()%></td>
					<td><%=p.getNumCorrette()%></td>
					<td><%=p.getNumSbagliate()%></td>
					<td><%=p.getNumSaltate()%></td>
					<td><%=p.getLivelloRaggiunto()%></td>
					<td><%=p.getTempoImpiegato()%></td>
					<td><%=p.getErrore1()%></td>
					<td><%=p.getErrore2()%></td>
					<td><%=p.getErrore3()%></td>
					<td><%=p.getErrore4()%></td>
					<td><%=p.getDomanda1()%></td>
					<td><%=p.getDomanda2()%></td>
					<td><%=p.getDomanda3()%></td>
					<td><%=p.getDomanda4()%></td>
					<td><%=p.getDomanda5()%></td>
					<td><%=p.getDomanda6()%></td>
					<td><%=p.getDomanda7()%></td>
					<td><%=p.getDomanda8()%></td>
					<td><a href="Util?action=detail" ><i class="fas fa-search-plus"></i></a></td>
				</tr>
				<%
					i++;
						}
					}
				%>
			</tbody>
		</table>
		
	</div>
	<a href="Util?action=clear"><input type="reset" value="reset" /></a>
	<a href="Util?action=download"><input type="button" class="input1"
		value="download" /></a>
		
</body>
</html>