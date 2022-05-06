package Biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import FachadaDaoLibro.FachadaLibroImpl;
import FachadaDaoLibro.IFachadaLibro;
import FachadaDaoPelicula.FachadaPeliculaImpl;
import FachadaDaoPelicula.IFachadaPelicula;
import FachadaDaoUsuario.FachadaUsuarioImpl;
import FachadaDaoUsuario.IFachadaUsuario;

public class Biblioteca {

	private static Biblioteca biblioteca;
	private DatabaseConnection database;
	private IFachadaUsuario _IFUsuario;
	private IFachadaLibro _IFLibro;
	private IFachadaPelicula _IFPelicula;

	private Biblioteca() {
		this.database = DatabaseConnection.getDatabase(); // Singleton crea la unica instancia de la base de datos
		this._IFUsuario = new FachadaUsuarioImpl();
		this._IFLibro = new FachadaLibroImpl();
		this._IFPelicula = new FachadaPeliculaImpl();
		// ...
	}

	public static Biblioteca getBiblioteca() {
		// Esta funci�n hace de Singleton
		if (biblioteca == null) {
			biblioteca = new Biblioteca();
		}
		return biblioteca;
	}

	public Usuario iniciarSesion(String email, String password) {
		return _IFUsuario.iniciarSesion(email, password);
	}

	public boolean registrarUsuario(String name, String email, String password) {
		Usuario user = new Usuario(name, email, password, 0);
		return this._IFUsuario.registrarUsuario(user);
	}

	public boolean existeUsuario(String email) {
		return _IFUsuario.existeUsuario(email);
	}

	public boolean esAdmin(String email) {
		return _IFUsuario.esAdmin(email);
	}

	public boolean altaLibro(Libro libro) {
		return _IFLibro.altaLibro(libro);
	}

	public boolean modificarUsuario(Usuario us) {
		return _IFUsuario.modificarUsuario(us);
	}

	public List<Libro> buscarLibro(String titulo) {
		return _IFLibro.buscarLibro(titulo);
	}

	public List<Pelicula> buscarPelicula(String titulo) {
		return _IFPelicula.buscarPelicula(titulo);
	}

	public boolean eliminarLibro(String ISBN) {
		return _IFLibro.bajaLibro(ISBN);
	}

	public boolean modificarLibro(Libro libro) {
		return _IFLibro.modificarLibro(libro);
	}

	public String existeLibro(String id) {
		String s = null;
		Libro l = _IFLibro.consultaLibro(id);

		if (l == null) {

			return null;
		} else {
			s = l.toString();
			return s;
		}
	}

	public String mostrarLibros() {
		List<Libro> p = new ArrayList<Libro>(_IFLibro.listaLibros());
		if (p.isEmpty()) {
			return null;
		} else {
			String s = "";
			for (Libro l : p) {
				s += l.toString();
				s += "--------------" + '\n';
			}
			return s;
		}
	}

	public boolean altaPelicula(Pelicula pelicula) {

		return _IFPelicula.altaPelicula(pelicula);
	}

	public boolean modificarPelicula(Pelicula pelicula) {

		return _IFPelicula.modificarPelicula(pelicula);
	}

	public boolean eliminarPelicula(String iSBN) {

		return _IFPelicula.bajaPelicula(iSBN);
	}

	public String existePelicula(String id) {
		String s = null;
		Pelicula p = _IFPelicula.consultaPelicula(id);

		if (p == null) {

			return null;
		} else {
			s = p.toString();
			return s;
		}
	}

	public String mostrarPeliculas() {
		List<Pelicula> p = new ArrayList<Pelicula>(_IFPelicula.listaPeliculas());
		if (p.isEmpty()) {
			return null;
		} else {
			String s = "";
			for (Pelicula peli : p) {
				s += peli.toString();
				s += "--------------" + '\n';
			}
			return s;
		}

	}

	public boolean deleteUsuario(String email) {
		return   _IFUsuario.deleteUsuario(email);
	}

	public boolean prestamoPelicula(String ISAN, Usuario usuario) {
		return _IFPelicula.prestamoPelicula(ISAN, usuario);
	}
	
	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		return _IFLibro.prestamoLibro(ISBN, usuario);
	}

	public boolean existeEmail(String email) {
		return _IFUsuario.existeEmail(email);
	}
	
}
