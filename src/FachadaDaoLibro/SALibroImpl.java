package FachadaDaoLibro;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;

public class SALibroImpl implements ISALibro {

	IFachadaLibroDao ifLibro = new FachadaLibroDaoImpl();
	
	@Override
	public boolean altaLibro(Libro libro) {
		return ifLibro.altaLibro(libro);
	}

	@Override
	public boolean bajaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return ifLibro.bajaLibro(ISBN);
	}
	
	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		return ifLibro.prestamoLibro(ISBN, usuario);
	}

	@Override
	public boolean modificarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return ifLibro.modificarLibro(libro);
	}

	@Override
	public Libro consultaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return ifLibro.consultaLibro(ISBN);
	}
	
	public List<Libro> buscarLibro(String titulo) {
		return ifLibro.buscarLibro(titulo);
	}

	@Override
	public List<Libro> listaLibros() {
		// TODO Auto-generated method stub
		return ifLibro.listaLibros();
	}

}
