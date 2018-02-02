package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Alquiler;
import es.altair.bean.Usuario;
import es.altair.bean.Vehiculo;
import es.altair.util.SessionProvider;

public class VehiculoDAOImplHibernate implements VehiculoDAO {

	public void insertar(Vehiculo v) {
	

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.save(v);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}

	
	}

	public void eliminar(Vehiculo v) {

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			 sesion
					.createSQLQuery("DELETE FROM vehiculos where idVehiculo=:id").setParameter("id", v.getId())
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		
	}

	

	public List<Vehiculo> listar(Usuario u) {
		List<Vehiculo> lista = new ArrayList<Vehiculo>();

		
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista =  sesion
					.createSQLQuery(
							"SELECT v FROM vehiculos v join alquileres on(vehiculos.idVehiculo=alquileres.idVehiculo where alquileres.idUser=:id")
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

	public List<Vehiculo> listarTodos() {
		
		List<Vehiculo> lista = new ArrayList<Vehiculo>();
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista = sesion.createQuery("FROM Vehiculo v ").list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
		
		return lista;
	}

	public void borrar(int id) {
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.createSQLQuery("Delete from vehiculos where idVehiculo=:id ").setParameter("id", id);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();

		}
		
		
	}

	
	public void borrar(String id) {
		  Session sesion = SessionProvider.getSession();
		  try {
		   sesion.beginTransaction();

		   sesion.createQuery("DELETE FROM Vehiculo WHERE uuid=:clave")
		   .setParameter("clave", id)
		   .executeUpdate();
		   
		   sesion.getTransaction().commit();
		  } catch (Exception e) {
		   // TODO: handle exception
		  } finally {
		   sesion.close();
		   // sf.close();
		  }
	
	}
	
	
	
	
	
	public List<Vehiculo> listarDisponibles() {
		List<Vehiculo> lista = new ArrayList<Vehiculo>();
		
		
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista = sesion.createSQLQuery("select * from vehiculos where vehiculos.idVehiculo not in"+ 
					"(SELECT idVehiculo FROM alquileres where current_date() between alquileres.fechaInicio and alquileres.fechaFin)").addEntity(Vehiculo.class).list();


			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
				
		return lista;
	}

	public Vehiculo obtener(String s) {
		
		Vehiculo v = new Vehiculo();
		
		
		Session sesion = SessionProvider.getSession();
		try {
			int id = Integer.parseInt(s);
			sesion.beginTransaction();

			v = (Vehiculo) sesion.createSQLQuery("Select * from vehiculos where idVehiculo=:id").setParameter("id", id).uniqueResult();


			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
				
		return v;
	}

	public Vehiculo obtener(int id) {
		Vehiculo v = null;
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			v = (Vehiculo) sesion
					.createQuery(
							"SELECT v FROM Vehiculo v WHERE id=:id ")
					.setParameter("id",id).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return v;
	}
	
public void editar(int id, String marca, String modelo, String matricula, int anyo) {
		
		
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.createQuery("update Vehiculo set marca=:mar, modelo=:mod, matricula=:mat, anyo=:a where id=:id")
					.setParameter("id", id).setParameter("mar", marca).setParameter("mod", modelo)
					.setParameter("mat", matricula).setParameter("a", anyo).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

	}


}
