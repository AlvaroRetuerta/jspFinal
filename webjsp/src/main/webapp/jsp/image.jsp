<%@page import="java.io.OutputStream"%><%@page import="es.altair.dao.VehiculoDAOImplHibernate"%><%@page import="es.altair.dao.VehiculoDAO"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%
try {
	String idVehiculo = request.getParameter("imag");
	VehiculoDAO vDAO = new VehiculoDAOImplHibernate();
	byte[] imagen = vDAO.obtenerImagenPorId(Integer.parseInt(idVehiculo));
	try {
		if (imagen != null) {
			response.setContentType("image/jpeg");
			response.setHeader("Content-Disposition", "attachment");
			OutputStream o = response.getOutputStream();
			o.write(imagen);
			o.flush();
			o.close();
			return;
		}
	} catch (IllegalStateException e) {	
	}
} catch (Exception e) {	
}
%>