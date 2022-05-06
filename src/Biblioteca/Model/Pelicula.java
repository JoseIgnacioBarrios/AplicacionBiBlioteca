package Biblioteca.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class Pelicula {
	String ISAN;
	String titulo;
	int duracion;
	String categoria;
	boolean disponibilidad;

	public Pelicula(String ISAN, String titulo, int duracion, String categoria, boolean d) {
		this.ISAN = ISAN;
		this.titulo = titulo;
		this.duracion = duracion;
		this.categoria = categoria;
		this.disponibilidad = d;
	}

	public String toString() {
		String s;
		s = "ISAN: " + ISAN + '\n' + "Titulo: " + titulo + '\n' + "Duracion: " + duracion + "min" + '\n' + "Categoria: "
				+ categoria + '\n' + "Disponible: ";
		if (disponibilidad) {
			s += "Si";
		} else {
			s += "No";
		}
		s += '\n';
		return s;
	}
	
	public int getID() {
		int id = -1;
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select id from pelicula where ISAN =?");
			ps.setString(1, this.ISAN);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String getISAN() {
		return this.ISAN;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setISAN(String ISBN) {
		this.ISAN = ISBN;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
