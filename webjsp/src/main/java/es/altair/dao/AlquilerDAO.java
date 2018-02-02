package es.altair.dao;

import java.util.List;

import es.altair.bean.Alquiler;

public interface AlquilerDAO {

	public int save(Alquiler a);
	
	public List<Alquiler> alquileresActuales();
	
	public List<Alquiler> lista();
	
}
