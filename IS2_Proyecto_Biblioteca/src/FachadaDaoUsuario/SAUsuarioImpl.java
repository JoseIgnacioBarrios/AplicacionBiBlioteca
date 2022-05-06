package FachadaDaoUsuario;

import java.util.ArrayList;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public class SAUsuarioImpl implements ISAUsuario{

	IFachadaUsuarioDao ifUsuario = new FachadaUsuarioDaoImpl();
	
	@Override
	public boolean existeUsuario(String email) {
		return ifUsuario.existeUsuario(email);
	}

	@Override
	public boolean registrarUsuario(Usuario us) {
		return ifUsuario.registrarUsuario(us);
	}

	@Override
	public boolean deleteUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return ifUsuario.deleteUsuario(us);
	}
	@Override
	public boolean deleteUsuario(String us) {
		// TODO Auto-generated method stub
		return ifUsuario.deleteUsuario(us);
	}

	@Override
	public boolean modificarUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return ifUsuario.modificarUsuario(us);
	}

	@Override
	public Usuario iniciarSesion(String email, String password) {
		return ifUsuario.iniciarSesion(email, password);
	}

	public Usuario consultaUsuario(String email) {
		return ifUsuario.consultaUsuario(email);
	};

	@Override
	public boolean esAdmin(String email) {
		// TODO Auto-generated method stub
		return ifUsuario.esAdmin(email);
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
		return ifUsuario.existeEmail(email);
	}

	

}
