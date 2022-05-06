package FachadaDaoLibro;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public interface IFachadaLibroDao {

	public boolean altaLibro(Libro libro);
	public boolean bajaLibro(String ISBN);
	public boolean modificarLibro(Libro libro);
	public Libro consultaLibro(String ISBN);
	public List<Libro> buscarLibro(String titulo);
	public List<Libro> listaLibros();	
	public boolean prestamoLibro(String ISBN, Usuario usuario);
}
