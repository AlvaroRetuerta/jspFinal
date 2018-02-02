<%@page import="es.altair.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A�adir Vehiculo</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/a�adir.css">
<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
<header> <h1>A�adir Vehiculo </h1></header>





	<div class="container">

		<%
			if (session.getAttribute("usuLogeado") == null || session.isNew()) {
				response.sendRedirect("../index.jsp?mensaje=Inicie sesi�n");
			} else {
				
		%>

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido
						<%=((Usuario) session.getAttribute("usuLogeado")).getNombre()%>
				</a></li>
				<li class="breadcrumb-item"><a href="principal.jsp">Principal
						Usuario</a></li>
				<li class="breadcrumb-item">A�adir Vehiculo</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar
						Sesi�n</a></li>
			</ol>
		</div>

		<div class="row">
				
				<form class="col-12" action="../AnadirVehiculo">
  <!--  General -->
  <div class="form-group">
    <h2 class="heading">General</h2>
    <div class="controls">
      <input type="text" id="marca" class="floatLabel" name="marca">
      <label for="marca">Marca</label>
    </div>
    <div class="controls">
      <input type="text" id="modelo" class="floatLabel" name="modelo">
      <label for="modelo">Modelo</label>
    </div>
     <div class="controls">
      <input type="text" id="matricula" class="floatLabel" name="matricula">
      <label for="matricula">Matricula</label>
    </div>
  </div>
  <!--  Details -->
  <div class="form-group">
    <h2 class="heading">Detalles</h2>
    <div class="controls">
      <input type="text" id="anyo" class="floatLabel" name="anyo">
      <label for="anyo">A�o</label>
    </div>
    <div class="controls">
      <i class="fa fa-sort"></i>
      <select class="floatLabel">
        <option value="blank"></option>
        <option value="EEUU">EEUU</option>
        <option value="Alemania">Alemania</option>
        <option value="Japon">Japon</option>
        <option value="Espa�a">Espa�a</option>
        <option value="Inglaterra">Inglaterra</option>
        <option value="Italia">Italia</option>
        <option value="Francia">Francia</option>
        <option value="Otro">Otro</option>
      </select>
      <label for="pais">Pais</label>
    </div>
  </div>
 <input type="submit" value="Enviar" class="form-control btn btn-primary">
</form>
				
				
				
				
			
		</div>


		<%
			}
		%>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	
	<script >(function($){
	function floatLabel(inputType){
		$(inputType).each(function(){
			var $this = $(this);
			// on focus add cladd active to label
			$this.focus(function(){
				$this.next().addClass("active");
			});
			//on blur check field and remove class if needed
			$this.blur(function(){
				if($this.val() === '' || $this.val() === 'blank'){
					$this.next().removeClass();
				}
			});
		});
	}
	// just add a class of "floatLabel to the input field!"
	floatLabel(".floatLabel");
})(jQuery);
//# sourceURL=pen.js
</script>
	
	
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>