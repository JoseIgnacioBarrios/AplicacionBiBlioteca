package FachadaDaoUsuario;

import java.util.ArrayList;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public interface IFachadaUsuarioDao {
	public boolean existeUsuario(String email);
	public boolean registrarUsuario(Usuario us);
	public boolean deleteUsuario(Usuario us);
	public boolean deleteUsuario(String us);
	public boolean modificarUsuario(Usuario us);
	public Usuario iniciarSesion(String email, String password );
	public Usuario consultaUsuario(String email);
	public ArrayList<Libro> consultarFavoritos(Usuario us);
	public ArrayList<Usuario> consultaTodos();
	public boolean esAdmin(String email);
	public boolean existeEmail(String email);
}
