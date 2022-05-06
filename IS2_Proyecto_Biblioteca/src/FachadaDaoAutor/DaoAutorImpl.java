package FachadaDaoAutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Model.Autor;
import Database.DatabaseConnection;

public class DaoAutorImpl implements IDaoAutor {

	public boolean altaAutor(Autor autor) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"insert into autor (name) values(?)");
			ps.setString(1, autor.getName());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean bajaAutor(String name) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("delete from autor where name = ?");
			ps.setString(1, name);
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean modificarAutor(Autor autor, String old_name) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"update autor set name=? where id=?");
			ps.setString(1, autor.getName());
			ps.setInt(2, consultaAutor(old_name).getId());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Autor consultaAutor(String name) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select id, name from autor where name= ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Autor(rs.getInt(1), rs.getString(2));
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Autor> buscarAutor(String name) {
		List<Autor> autors = new ArrayList<Autor>();
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from autor where name like ?");
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				autors.add(new Autor(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autors;
	}

	public List<Autor> listaAutors() {
		try {
			List<Autor> lista = new ArrayList<Autor>();
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from autor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Autor(rs.getInt("id"), rs.getString("name")));
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
