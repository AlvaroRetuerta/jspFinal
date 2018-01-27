package es.altair.dao;

import es.altair.bean.Usuario;

public interface UsuarioDAO {

	boolean validarEmail(Usuario usu);

	int insertar(Usuario usu);

	Usuario comprobarUsuario(String login, String password);
}
