package FachadaDaoLibro;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public class FachadaLibroDaoImpl implements IFachadaLibroDao {

	IDaoLibro iLibro = new  DaoLibroImpl();
	public boolean altaLibro(Libro libro) {
		return iLibro.altaLibro(libro);
	}
	
	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		return iLibro.prestamoLibro(ISBN, usuario);
	}

	public boolean bajaLibro(String ISBN) {
		return iLibro.bajaLibro(ISBN);
	}

	public boolean modificarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return iLibro.modificarLibro(libro);
	}

	public Libro consultaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return iLibro.consultaLibro(ISBN);
	}
	
	public List<Libro> buscarLibro(String titulo) {
		return iLibro.buscarLibro(titulo);
	}

	public List<Libro> listaLibros() {
		// TODO Auto-generated method stub
		return iLibro.listaLibros()
				;
	}

}
