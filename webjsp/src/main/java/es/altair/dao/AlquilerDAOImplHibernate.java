package es.altair.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.bean.Alquiler;
import es.altair.util.SessionProvider;

public class AlquilerDAOImplHibernate implements AlquilerDAO {

	public int save(Alquiler a) {
		int filas=0;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			
			sesion.beginTransaction();
			filas = sesion.createSQLQuery("INSERT INTO alquileres (idUser, idVehiculo, fechaInicio, fechaFin)"
							+ "values (:u, :v, :fi,:ff)")
				.setParameter("u", a.getUsuario().getIdUser()).setParameter("v", a.getVehiculo().getId()).setParameter("fi", a.getFechaInicio())
				.setParameter("ff", a.getFechaFin()).executeUpdate();

			sesion.getTransaction();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sesion.close();
			sf.close();
		}
		return filas;
	}

	public List<Alquiler> alquileresActuales() {
		List<Alquiler> lista = new ArrayList<Alquiler>();
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista = sesion.createQuery("select idVehiculo FROM Alquiler a where current_date() between fechaInicio and fechaFin").list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();

		}
		
		
		return lista;
	}

}
