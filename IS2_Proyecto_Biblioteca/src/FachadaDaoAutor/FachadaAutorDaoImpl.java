package FachadaDaoAutor;

import java.util.List;

import Biblioteca.Model.Autor;

public class FachadaAutorDaoImpl implements IFachadaAutorDao {

	IDaoAutor iAutor = new  DaoAutorImpl();
	public boolean altaAutor(Autor autor) {
		return iAutor.altaAutor(autor);
	}

	public boolean bajaAutor(String name) {
		// TODO Auto-generated method stub
		return iAutor.bajaAutor(name);
	}

	public boolean modificarAutor(Autor autor, String old_name) {
		// TODO Auto-generated method stub
		return iAutor.modificarAutor(autor, old_name);
	}

	public Autor consultaAutor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Autor> buscarAutor(String name) {
		return iAutor.buscarAutor(name);
	}

	public List<Autor> listaAutors() {
		// TODO Auto-generated method stub
		return null;
	}

}
