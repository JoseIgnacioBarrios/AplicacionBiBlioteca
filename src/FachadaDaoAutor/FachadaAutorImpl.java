package FachadaDaoAutor;

import java.util.List;

import Biblioteca.Model.Autor;
import Biblioteca.Model.Pelicula;

public class FachadaAutorImpl implements IFachadaAutor {

	ISAAutor iAutor = new SAAutorImpl();

	@Override
	public boolean altaAutor(Autor autor) {
		return iAutor.altaAutor(autor);
	}

	@Override
	public boolean bajaAutor(String name) {
		// TODO Auto-generated method stub
		return iAutor.bajaAutor(name);
	}

	@Override
	public Autor consultaAutor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Autor> buscarAutor(String autor) {
		return iAutor.buscarAutor(autor);
	}

	@Override
	public List<Autor> listaAutors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarAutor(Autor autor, String old_name) {
		return iAutor.modificarAutor(autor, old_name);
	}

}
