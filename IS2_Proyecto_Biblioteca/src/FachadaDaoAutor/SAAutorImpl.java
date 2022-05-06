package FachadaDaoAutor;

import java.util.List;

import Biblioteca.Model.Autor;

public class SAAutorImpl implements ISAAutor {

	IFachadaAutorDao ifAutor = new FachadaAutorDaoImpl();

	@Override
	public boolean altaAutor(Autor autor) {
		return ifAutor.altaAutor(autor);
	}

	@Override
	public boolean bajaAutor(String name) {
		// TODO Auto-generated method stub
		return ifAutor.bajaAutor(name);
	}

	@Override
	public boolean modificarAutor(Autor autor, String old_name) {
		// TODO Auto-generated method stub
		return ifAutor.modificarAutor(autor, old_name);
	}

	@Override
	public Autor consultaAutor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Autor> buscarAutor(String name) {
		return ifAutor.buscarAutor(name);
	}

	@Override
	public List<Autor> listaAutors() {
		// TODO Auto-generated method stub
		return null;
	}

}
