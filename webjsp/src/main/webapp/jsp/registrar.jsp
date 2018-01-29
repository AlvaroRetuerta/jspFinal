<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/css.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h1>Registro</h1>
				<%
					String error = request.getParameter("mensaje");
					if (error != null) {
				%>
				<div class="alert alert-warning alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">x</button>
					<strong>Info!</strong>
					<%=error%>
				</div>
				<%
					}
				%>
				<hr>
				<form action="../RegistrarUsuario" class="" method="post">

					<div class="form-group">
						<label class="col-sm-2 control-label" for="nombre">Nombre</label>
						<div class="col-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
			
								<input type="text" id="nombre" name="nombre"
									placeholder="Nombre" class="form-control input-md" required>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="apellidos">Apellidos</label>
						<div class="col-sm-10">
						<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
						
							<input type="text" id="apellidos" name="apellidos"
								placeholder="Apellidos" class="form-control input-md" required>
								</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="username">Username</label>
						<div class="col-sm-10">
						<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
							<input type="text" id="username" name="username"
								placeholder="Username" class="form-control input-md" required>
								</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="password">Password</label>
						<div class="col-sm-10">
						<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input type="text" id="password" name="password"
								placeholder="Password" class="form-control input-md" required>
								</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="email">Email</label>
						<div class="col-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<input type="email" id="email" name="email" placeholder="Email"
								class="form-control input-md" required>
								</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<input type="submit" value="Enviar" class="btn btn-primary btn-lg btn-block login-button">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>