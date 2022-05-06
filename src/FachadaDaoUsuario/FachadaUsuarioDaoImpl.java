package FachadaDaoUsuario;

import java.util.ArrayList;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public class FachadaUsuarioDaoImpl implements IFachadaUsuarioDao {

	IDaoUsuario idUsuario = new DaoUsuarioImpl();
	
	@Override
	public boolean existeUsuario(String email) {
		return idUsuario.existeUsuario(email);
	}

	@Override
	public boolean registrarUsuario(Usuario us) {
		return idUsuario.registrarUsuario(us);
	}

	@Override
	public boolean deleteUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return idUsuario.deleteUsuario(us);
	}
	@Override
	public boolean deleteUsuario(String us) {
		// TODO Auto-generated method stub
		return idUsuario.deleteUsuario(us);
	}

	@Override
	public boolean modificarUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return idUsuario.modificarUsuario(us);
	}

	@Override
	public Usuario iniciarSesion(String email, String password) {
		return idUsuario.iniciarSesion(email, password);
	}

	public Usuario consultaUsuario(String email) {
		return idUsuario.consultaUsuario(email);
	};

	@Override
	public boolean esAdmin(String email) {
		// TODO Auto-generated method stub
		return idUsuario.esAdmin(email);
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
		return idUsuario.existeEmail(email);
	}

	

}
