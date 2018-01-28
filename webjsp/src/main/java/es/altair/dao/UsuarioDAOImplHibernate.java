package es.altair.dao;

import org.hibernate.Session;

import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	private String pass = "Altair123$%";
	
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
					.createSQLQuery("INSERT INTO users (nombre, apellidos, username, password, email, tipo)"
							+ "values (:n, :a, :u, AES_ENCRYPT(:p, :passphrase), :e, :t)")
					.setParameter("u", usu.getUsername()).setParameter("p", usu.getPassword()).setParameter("passphrase", pass).setParameter("a", usu.getApellidos())
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
					.createSQLQuery(
							"SELECT * FROM users WHERE username=:l AND password=AES_ENCRYPT(:p, :passphrase)")
					.setParameter("l", login).setParameter("p", password).setParameter("passphrase", pass)
					.uniqueResult();
			sesion.getTransaction().commit();
		} catch (Exception e) {
				
		} finally {
			sesion.close();
			
		}

		return usu;
	}

	
	
}
