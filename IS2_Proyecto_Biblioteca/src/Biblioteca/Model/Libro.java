package Biblioteca.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class Libro {
	String ISBN;
	String titulo;
	String autor;
	int autor_id;
	String editorial;
	boolean disponibilidad;

	public Libro(String ISBN, String titulo, int autor_id, String editorial, boolean disponibilidad) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor_id = autor_id;
		this.editorial = editorial;
		this.disponibilidad = disponibilidad;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String disponible = disponibilidad ? "disponible" : "no disponible";
		s.append("Titulo: ").append(titulo).append(" ").append("Autor: ").append(autor).append(" ")
				.append("Editorial: ").append(" ").append(editorial).append(disponible);
		return s.toString();
	}

	public int getID() {
		int id = -1;
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select id from libro where ISBN =?");
			ps.setString(1, this.ISBN);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void setAutor(String nombre) {
		this.autor = nombre;
	}

	public String getAutor() {
		String nombre_autor = null;
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select name from autor where id =?");
			ps.setInt(1, this.autor_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nombre_autor = rs.getString("name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre_autor;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getAutorId() {
		return this.autor_id;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutorId(int autor_id) {
		this.autor_id = autor_id;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
