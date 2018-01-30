package es.altair.dao;

import java.util.List;

import es.altair.bean.Usuario;
import es.altair.bean.Vehiculo;

public interface VehiculoDAO {
	
	public int insertar(Vehiculo v);
	
	public void eliminar(Vehiculo v);
	
	public Vehiculo obtener(String matricula);
	
	public List<Vehiculo> listar(Usuario u);
	
	public byte[] obtenerImagenPorId(int id);

	public List<Vehiculo> listarTodos();

	public void borrar(String matricula);
	
}
