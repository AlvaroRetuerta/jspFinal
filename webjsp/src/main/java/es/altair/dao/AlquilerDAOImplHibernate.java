package es.altair.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Alquiler;

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

}
