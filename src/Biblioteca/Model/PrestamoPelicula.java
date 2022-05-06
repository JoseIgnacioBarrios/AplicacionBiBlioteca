package Biblioteca.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class PrestamoPelicula {
	int user_id;
	int pelicula_id;
	String fecha_devolucion;

	public PrestamoPelicula(int user_id, int pelicula_id, String fecha) {
		this.user_id = user_id;
		this.pelicula_id = pelicula_id;
		this.fecha_devolucion = fecha;
	}


	public Pelicula getPelicula() {
		Pelicula pelicula = null;
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from pelicula where id = ? ");
			ps.setString(1, Integer.toString(pelicula_id));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pelicula = new Pelicula(rs.getString("ISAN"), rs.getString("titulo"), rs.getInt("duracion"),
						rs.getString("categoria"), rs.getBoolean("disponibilidad"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pelicula;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getBook_id() {
		return pelicula_id;
	}

	public String getFecha_devolucion() {
		return fecha_devolucion;
	}
}
