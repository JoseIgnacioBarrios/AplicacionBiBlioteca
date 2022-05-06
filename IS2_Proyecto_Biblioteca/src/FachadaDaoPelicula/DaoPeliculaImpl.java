package FachadaDaoPelicula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;
import Database.DatabaseConnection;
import DateFormatter.formatter;

public class DaoPeliculaImpl implements IDaoPelicula {

	public boolean altaPelicula(Pelicula pelicula) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("insert into pelicula values(NULL,?,?,?,?,?)");
			ps.setString(1, pelicula.getISAN());
			ps.setString(2, pelicula.getTitulo());
			ps.setInt(3, pelicula.getDuracion());
			ps.setString(4, pelicula.getCategoria());
			ps.setBoolean(5, pelicula.getDisponibilidad());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean bajaPelicula(String ISBN) {
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("delete from pelicula where ISAN = ?");

			ps.setString(1, ISBN);
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean modificarPelicula(Pelicula pelicula) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"update pelicula set titulo=?, duracion=?, categoria=?, disponibilidad=? where ISAN=?");

			ps.setString(1, pelicula.getTitulo());
			ps.setInt(2, pelicula.getDuracion());
			ps.setString(3, pelicula.getCategoria());
			ps.setBoolean(4, pelicula.getDisponibilidad());
			ps.setString(5, pelicula.getISAN());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Pelicula> buscarPelicula(String titulo) {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from pelicula where titulo like ?");
			ps.setString(1, "%" + titulo + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getString("ISAN"), rs.getString("titulo"), rs.getInt("duracion"),
						rs.getString("categoria"), rs.getBoolean("disponibilidad")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}

	public Pelicula consultaPelicula(String ISAN) {
		Pelicula pelicula = null;
		try {

			PreparedStatement ps = DatabaseConnection.connection
					.prepareStatement("select * from pelicula where ISAN= ?");
			ps.setString(1, ISAN);
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

	public List<Pelicula> listaPeliculas() {
		try {
			List<Pelicula> lista = new ArrayList<Pelicula>();
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from pelicula");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pelicula p = new Pelicula(rs.getString("isan"), rs.getString("titulo"), rs.getInt("duracion"),
						rs.getString("categoria"), rs.getBoolean("disponibilidad"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean prestamoPelicula(String ISAN, Usuario usuario) {
		try {
			Pelicula pelicula = consultaPelicula(ISAN);
			int id_usuario = usuario.getID();
			if (id_usuario == -1 || pelicula == null || usuario.tienePrestamoPelicula(pelicula.getID())
					|| !pelicula.getDisponibilidad()) {
				return false;
			}

			PreparedStatement ps = DatabaseConnection.connection.prepareStatement(
					"insert into prestamo_pelicula (usuario_id, pelicula_id, dia_prestamo) values ( ?, ?, ?)");
			ps.setInt(1, usuario.getID());
			ps.setInt(2, pelicula.getID());
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

}
