package FachadaDaoAutor;

import java.util.List;

import Biblioteca.Model.Autor;

public interface IFachadaAutor {
	public boolean altaAutor(Autor autor);
	public boolean bajaAutor(String name);
	public boolean modificarAutor(Autor autor, String old_name);
	public Autor consultaAutor(String name);
	public List<Autor> buscarAutor(String autor);
	public List<Autor> listaAutors();
}
