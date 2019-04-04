<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-lg fixed-top navbar-default"
	role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-brand-centered">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="navbar-brand navbar-brand-centered">
				<img src="img/dsa_logo.png" id="icon" alt="DSA Admin Console" />
			</div>
		</div>
<!-- 	<div class="collapse navbar-collapse navbar-brand-left" id="">
			<h3>Modalità di visualizzazione</h3>
		</div>-->
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbar-brand-centered">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Cod. Plesso <span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-form" role="menu">
						<li>
							<form class="form-group" role="form" action="PlessoSearch"
								method="post">
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker9'>
											<input type='text' class="form-control"
												placeholder="Codice Plesso" name="codicePlesso" required/>
										</div>
									</div>
									<input type="submit" class="btn-nav" value="Invia">
								</div>
							</form>
						</li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Per data<span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-form" role="menu">
						<li>
							<form class="form-group" role="form" method="post"
								action="DataSearch">
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker9'>
											<label>Data iniziale</label> <input type='date'
												class="form-control" name="dataInizio" required/>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker10'>
											<label>Data finale</label> <input type='date'
												class="form-control" name="dataFine"
												required/>
										</div>
									</div>
								</div>
								<input type="submit" class="btn-nav" value="Invia">
							</form>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Cod. Classe <span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-form" role="menu">
						<li>
							<form class="form-group" role="form" action="ClasseSearch"
								method="post">
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker9'>
											<input type='text' name="codiceClasse" class="form-control"
												placeholder="Codice classe" required/>
										</div>
									</div>
									<input type="submit" class="btn-nav" value="Invia">
								</div>
							</form>
						</li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Cod. studente<span class="caret"></span></a>
					<ul class="dropdown-menu dropdown-form" role="menu">
						<li>
							<form class="form-group" role="form" method="post"
								action="StudSearch">
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker9'>
											 <input type='text'
												class="form-control" placeholder="Codice classe" name="codiceClasseStud" required/>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<div class='input-group text-bar' id='datetimepicker10'>
											<input type='text'
												class="form-control" name="codiceStudente"
												placeholder="Codice Studente" required/>
										</div>
									</div>
								</div>
								<input type="submit" class="btn-nav" value="Invia">
							</form>
					</ul></li>
					<li><a href="Util?action=logout">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>