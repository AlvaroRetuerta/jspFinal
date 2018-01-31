package es.altair.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.bean.Alquiler;
import es.altair.util.SessionProvider;

public class AlquilerDAOImplHibernate implements AlquilerDAO {

	public void save(Alquiler a) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			
			sesion.beginTransaction();
			sesion.save(a);
			sesion.getTransaction();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sesion.close();
			sf.close();
		}
		
	}

	public List<Alquiler> alquileresActuales() {
		List<Alquiler> lista = new ArrayList<Alquiler>();
		
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			lista = sesion.createQuery("FROM Alquiler a where current_date() between fechaInicio and fechaFin").list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();

		}
		
		
		return lista;
	}

}
