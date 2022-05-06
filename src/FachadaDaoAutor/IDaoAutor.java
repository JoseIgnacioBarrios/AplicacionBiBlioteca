package FachadaDaoAutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Model.Autor;
import Database.DatabaseConnection;

public interface IDaoAutor {

	public boolean altaAutor(Autor autor);
	public boolean bajaAutor(String name);
	public boolean modificarAutor(Autor autor, String old_name);
	public Autor consultaAutor(String name);
	public List<Autor> buscarAutor(String name);
	public List<Autor> listaAutors();
}
