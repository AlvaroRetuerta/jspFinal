package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Usuario;
import es.altair.bean.Vehiculo;
import es.altair.util.SessionProvider;

public class VehiculoDAOImplHibernate implements VehiculoDAO {

	public int insertar(Vehiculo v) {
		int filas = 0;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			filas = sesion
					.createSQLQuery("INSERT INTO vehiculos (matricula, marca, modelo, a�o, pais)"
							+ "values (:mat,:mar,:mod,:a,:p)")
					.setParameter("mat", v.getMatricula()).setParameter("mar", v.getMarca())
					.setParameter("mod", v.getModelo()).setParameter("a", v.getA�o()).setParameter("p", v.getPais())
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}

		return filas;
		
	}

	public void eliminar(Vehiculo v) {

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			 sesion
					.createSQLQuery("DELETE FROM vehiculos where id=:id").setParameter("id", v.getId())
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		
	}

	public Vehiculo obtener(String matricula) {
		Vehiculo v = null;
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			v = (Vehiculo) sesion
					.createQuery(
							"SELECT v FROM Vehiculo v WHERE matricula=:m ")
					.setParameter("m",matricula).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return v;
	}

	public List<Vehiculo> listar(Usuario u) {
		List<Vehiculo> lista = new ArrayList<Vehiculo>();

		
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista =  sesion
					.createQuery(
							"SELECT * FROM vehiculos join alquileres on(vehiculos.idVehiculo=alquileres.idVehiculo where alquileres.idUser=:id")
					.setParameter("id", u.getIdUser()).list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
		
		return lista;
	}

	public byte[] obtenerImagenPorId(int id) {
		byte[] imagen = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			imagen = (byte[]) sesion.createQuery("Select v.imagen From Vehiculo v Where v.idVehiculo=:id")
					.setParameter("id", id).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return imagen;

	}
	
	
	

}