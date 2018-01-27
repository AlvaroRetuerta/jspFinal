package es.altair.dao;

import org.hibernate.Session;

import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	public boolean validarEmail(Usuario usu) {
		boolean correcto = true;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			if ((Usuario) sesion.createQuery("From Usuario Where email=:e")
					.setParameter("e", usu.getEmail())
					.uniqueResult() != null)
				correcto = false;

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return correcto;
	}

	public int insertar(Usuario usu) {
		int filas = 0;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			filas = sesion
					.createSQLQuery("INSERT INTO usuarios (nombre, apellidos, username, password, email, tipo)"
							+ "values (:n, :a, :u, :p, :e, :t)")
					.setParameter("u", usu.getUsername()).setParameter("p", usu.getPassword()).setParameter("a", usu.getApellidos())
					.setParameter("n", usu.getNombre()).setParameter("e", usu.getEmail()).setParameter("t", usu.getTipo()).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}

		return filas;
	}
	
	public Usuario comprobarUsuario(String login, String password) {
		Usuario usu = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			usu = (Usuario) sesion
					.createQuery(
							"SELECT u FROM Usuario u WHERE login=:l " + "AND password=:p")
					.setParameter("l", login).setParameter("p", password).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			
		}

		return usu;
	}

	
	
}
