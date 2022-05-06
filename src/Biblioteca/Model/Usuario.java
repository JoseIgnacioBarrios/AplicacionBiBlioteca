package Biblioteca.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;

public class Usuario {
	String name;
	String email;
	String password;
	int admin;

	public Usuario(String nombre, String correo, String password, int admin) {
		this.name = nombre;
		this.email = correo;
		this.password = password;
		this.admin = admin;

	}
	//////
	public boolean tienePrestamoLibro() {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_libro where usuario_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean tienePrestamoPelicula() {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_pelicula where usuario_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/////
	public boolean tienePrestamoLibro(int libro_id) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_libro where usuario_id = ? and libro_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ps.setString(2, Integer.toString(libro_id));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean tienePrestamoPelicula(int pelicula_id) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_pelicula where usuario_id = ? and pelicula_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ps.setString(2, Integer.toString(pelicula_id));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<PrestamoLibro> getPrestamoLibro() {
		List<PrestamoLibro> prestamos = new ArrayList<PrestamoLibro>();
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_libro where usuario_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				prestamos.add(
						new PrestamoLibro(rs.getInt("usuario_id"), rs.getInt("libro_id"), rs.getString("dia_prestamo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prestamos;
	}
	
	public List<PrestamoPelicula> getPrestamoPelicula() {
		List<PrestamoPelicula> prestamos = new ArrayList<PrestamoPelicula>();
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from prestamo_pelicula where usuario_id = ?");
			ps.setString(1, Integer.toString(getID()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				prestamos.add(
						new PrestamoPelicula(rs.getInt("usuario_id"), rs.getInt("pelicula_id"), rs.getString("dia_prestamo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prestamos;
	}

	public int getID() {
		int id = -1;
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select id from usuario where email =?");
			ps.setString(1, this.email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public String getFechaCreacion() {
		String fecha_creacion = null;
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select created_at from usuario where email = ?");
			ps.setString(1, this.email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fecha_creacion = rs.getString("created_at");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fecha_creacion;
	}

	public int getAdmin() {
		return admin;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(String name) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("update usuario set name = ? where id = ?");
			ps.setString(1, name);
			ps.setInt(2, getID());
			ps.executeUpdate();
			this.name = name;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setEmail(String email) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("update usuario set email = ? where id = ?");
			ps.setString(1, email);
			ps.setInt(2, getID());
			ps.executeUpdate();
			this.email = email;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setPassword(String password) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("update usuario set password = ? where id = ?");
			ps.setString(1, password);
			ps.setInt(2, getID());
			ps.executeUpdate();
			this.password = password;

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
