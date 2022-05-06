package FachadaDaoLibro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;
import Database.DatabaseConnection;
import DateFormatter.formatter;

public class DaoLibroImpl implements IDaoLibro {

	public boolean altaLibro(Libro libro) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"insert into libro (ISBN, titulo, autor_id, editorial, disponibilidad) values(?,?,?,?,?)");
			ps.setString(1, libro.getISBN());
			ps.setString(2, libro.getTitulo());
			ps.setInt(3, libro.getAutorId());
			ps.setString(4, libro.getEditorial());
			ps.setBoolean(5, libro.getDisponibilidad());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean prestamoLibro(String ISBN, Usuario usuario) {
		try {
			Libro libro = consultaLibro(ISBN);
			int id_usuario = usuario.getID();
			if (id_usuario == -1 || libro == null || usuario.tienePrestamoLibro(libro.getID()) || !libro.getDisponibilidad()) {
				return false;
			}

			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"insert into prestamo_libro (usuario_id, libro_id, dia_prestamo) values ( ?, ?, ?)");
			ps.setInt(1, usuario.getID());
			ps.setInt(2, libro.getID());
			ps.setString(3, formatter.fechaDevolucion(7));
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean bajaLibro(String ISBN) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("delete from libro where ISBN = ?");
			ps.setString(1,ISBN);

			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean modificarLibro(Libro libro) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"update libro set titulo=?, autor_id=?, editorial=?, disponibilidad=? where ISBN=?");
			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getAutorId());
			ps.setString(3, libro.getEditorial());
			ps.setBoolean(4, libro.getDisponibilidad());
			ps.setString(5, libro.getISBN());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Libro consultaLibro(String ISBN) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from libro where ISBN= ?");
			ps.setString(1, ISBN);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Libro l = new Libro(ISBN, rs.getString("titulo"), rs.getInt("autor_id"), rs.getString("editorial"),
						rs.getBoolean("disponibilidad"));
				return l;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Libro> buscarLibro(String titulo) {
		List<Libro> libros = new ArrayList<Libro>();
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"select libro.ISBN, libro.titulo,autor.id, autor.name, libro.editorial, libro.disponibilidad "
							+ "from libro, autor  " + "where libro.autor_id = autor.id and libro.titulo like ?");
			ps.setString(1, "%" + titulo + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Libro libro_encontrado = new Libro(rs.getString("ISBN"), rs.getString("titulo"), rs.getInt("autor.id"),
						rs.getString("editorial"), rs.getBoolean("disponibilidad"));
				libro_encontrado.setAutor(rs.getString("autor.name"));
				libros.add(libro_encontrado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public List<Libro> listaLibros() {
		try {
			List<Libro> lista = new ArrayList<Libro>();
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from libro");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro l = new Libro(rs.getString("ISBN"), rs.getString("titulo"), rs.getInt("autor_id"),
						rs.getString("editorial"), rs.getBoolean("disponibilidad"));
				lista.add(l);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
