package es.altair.dao;

import java.util.List;

import es.altair.bean.Usuario;
import es.altair.bean.Vehiculo;

public interface VehiculoDAO {
	
	public void insertar(Vehiculo v);
	
	public void eliminar(Vehiculo v);
	
	public void borrar(String id);
	
	public List<Vehiculo> listar(Usuario u);
	
	public byte[] obtenerImagenPorId(int id);

	public List<Vehiculo> listarTodos();

	public void borrar(int id);

	public Vehiculo obtener(int id);
	
	public List<Vehiculo> listarDisponibles();
	
	public Vehiculo obtener(String id);

	public void editar(int id, String marca, String modelo, String matricula, int anyo);
}
