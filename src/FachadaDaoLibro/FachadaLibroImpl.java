package FachadaDaoLibro;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;

public class FachadaLibroImpl implements IFachadaLibro {
	
	ISALibro iLibro = new SALibroImpl();

	@Override
	public boolean altaLibro(Libro libro) {
		return iLibro.altaLibro(libro);
	}
	
	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		return iLibro.prestamoLibro(ISBN, usuario);
	}

	@Override
	public boolean bajaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return iLibro.bajaLibro(ISBN);
	}

	@Override
	public Libro consultaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return iLibro.consultaLibro(ISBN);
	}
	
	public List<Libro> buscarLibro(String titulo) {
		return iLibro.buscarLibro(titulo);
	}

	@Override
	public List<Libro> listaLibros() {
		// TODO Auto-generated method stub
		return iLibro.listaLibros();
	}

	@Override
	public boolean modificarLibro(Libro libro) {
		return iLibro.modificarLibro(libro);
	}
	
}
