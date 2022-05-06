package Biblioteca.Control;

import java.util.List;

import Biblioteca.Model.Biblioteca;
import Biblioteca.Model.Libro;
import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;

public class Controller {

	private Biblioteca biblioteca; // Modelo

	public Controller(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public boolean crearLibro(String ISBN, String titulo, int autor_id, String editorial, boolean disponibilidad) {
		Libro libro = new Libro(ISBN, titulo, autor_id, editorial, disponibilidad);
		return biblioteca.altaLibro(libro);
	}

	public Usuario iniciarSesion(String email, String password) {
		return biblioteca.iniciarSesion(email, password);
	}

	public boolean existeUsuario(String email) {
		return biblioteca.existeUsuario(email);
	}

	public boolean registrarUsuario(String name, String email, String password) {
		return biblioteca.registrarUsuario(name, email, password);
	}

	public boolean esAdmin(String email) {
		return biblioteca.esAdmin(email);
	}

	public boolean modificaUsuario(Usuario us) {
		return biblioteca.modificarUsuario(us);
	}

	public List<Libro> buscarLibro(String titulo) {
		return biblioteca.buscarLibro(titulo);
	}

	public List<Pelicula> buscarPelicula(String titulo) {
		return biblioteca.buscarPelicula(titulo);
	}

	public boolean crearPelicula(String isbn, String titulo, int duracion, String categoria, boolean b) {
		Pelicula pelicula = new Pelicula(isbn, titulo, duracion, categoria, true);
		return biblioteca.altaPelicula(pelicula);
	}

	public boolean eliminarLibro(String ISBN) {
		return biblioteca.eliminarLibro(ISBN);
	}

	public boolean modificarLibro(String ISBN, String titulo, int autor, String editorial, boolean disponibilidad) {
		Libro libro = new Libro(ISBN, titulo, autor, editorial, disponibilidad);
		return biblioteca.modificarLibro(libro);
	}

	public boolean editarPelicula(String isbn, String titulo, int duracion, String categoria, boolean b) {
		Pelicula pelicula = new Pelicula(isbn, titulo, duracion, categoria, true);
		return biblioteca.modificarPelicula(pelicula);
	}

	public boolean eliminarPelicula(String ISBN) {
		return biblioteca.eliminarPelicula(ISBN);
	}

	public String existeLibro(String id) {
		return biblioteca.existeLibro(id);
	}

	public String existePelicula(String id) {
		return biblioteca.existePelicula(id);
	}

	public String mostrarPeliculas() {
		return biblioteca.mostrarPeliculas();
	}

	public String mostrarLibros() {
		return biblioteca.mostrarLibros();
	}
	
	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		return biblioteca.prestamoLibro(ISBN, usuario);
	}
	
	public boolean prestamoPelicula(String ISAN, Usuario usuario) {
		return biblioteca.prestamoPelicula(ISAN, usuario);
	}

	public boolean deleteUsuario(String email) {
		return biblioteca.deleteUsuario(email);
	}
	
	public boolean existeEmail(String email) {
		return biblioteca.existeEmail(email);
	}

}
