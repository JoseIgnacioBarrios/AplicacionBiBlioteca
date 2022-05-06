package FachadaDaoUsuario;

import java.util.ArrayList;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public class FachadaUsuarioImpl implements IFachadaUsuario {

	ISAUsuario SAUsuario = new SAUsuarioImpl();
	
	@Override
	public boolean existeUsuario(String email) {
		return SAUsuario.existeUsuario(email);
	}

	@Override
	public boolean registrarUsuario(Usuario us) {
		return SAUsuario.registrarUsuario(us);
	}

	@Override
	public boolean deleteUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return SAUsuario.deleteUsuario(us);
	}
	@Override
	public boolean deleteUsuario(String us) {
		// TODO Auto-generated method stub
		return SAUsuario.deleteUsuario(us);
	}

	@Override
	public boolean modificarUsuario(Usuario us) {
		return SAUsuario.modificarUsuario(us);
	}

	@Override
	public Usuario iniciarSesion(String email, String password) {
		return SAUsuario.iniciarSesion(email, password);
	}

	public Usuario consultaUsuario(String email) {
		return SAUsuario.consultaUsuario(email);
	};

	@Override
	public boolean esAdmin(String email) {
		// TODO Auto-generated method stub
		return SAUsuario.esAdmin(email);
	}
	
	@Override
	public ArrayList<Libro> consultarFavoritos(Usuario us) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> consultaTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEmail(String email) {
		return SAUsuario.existeEmail(email);
	}

	

}
