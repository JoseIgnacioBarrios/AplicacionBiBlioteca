package FachadaDaoLibro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;
import Database.DatabaseConnection;

public interface IDaoLibro {

	public boolean altaLibro(Libro libro);
	public boolean bajaLibro(String ISBN);
	public boolean modificarLibro(Libro libro);
	public Libro consultaLibro(String ISBN);
	public List<Libro> buscarLibro(String titulo);
	public List<Libro> listaLibros();	
	public boolean prestamoLibro(String ISBN, Usuario usuario);
}
