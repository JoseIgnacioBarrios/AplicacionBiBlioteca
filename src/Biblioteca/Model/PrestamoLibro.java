package Biblioteca.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class PrestamoLibro {

	int user_id;
	int book_id;
	String fecha_devolucion;

	public PrestamoLibro(int user_id, int book_id, String fecha) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.fecha_devolucion = fecha;
	}

	public Libro getLibro() {
		Libro libro = null;
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"select * from libro where id = ? ");
			ps.setString(1, Integer.toString(book_id));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				libro = new Libro(rs.getString("ISBN"), rs.getString("titulo"), rs.getInt("autor_id"),
						rs.getString("editorial"), rs.getBoolean("disponibilidad"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libro;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public String getFecha_devolucion() {
		return fecha_devolucion;
	}

}
