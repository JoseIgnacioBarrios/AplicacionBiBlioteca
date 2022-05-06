package FachadaDaoUsuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Usuario;
import Database.DatabaseConnection;

public class DaoUsuarioImpl implements IDaoUsuario{

	public boolean existeUsuario(String email) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from usuario where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean registrarUsuario(Usuario us) {
		try {		
			if(existeUsuario(us.getEmail())) {
				return false;
			}
			// Don't need to fill auto-increment field
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("insert into usuario (name, email, password,admin) values(?,?,?,?)");

			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			ps.setInt(4, us.getAdmin());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	//Usuario us  cambiamos por String email????
	public boolean deleteUsuario(Usuario us) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("delete from usuario where email=?");
			ps.setString(1, us.getEmail());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean deleteUsuario(String us) {
		try {
			Usuario a=consultaUsuario(us);
			if(!a.tienePrestamoLibro() && !a.tienePrestamoPelicula())
			{
				PreparedStatement ps = DatabaseConnection.connection.prepareStatement("delete from usuario where email=?");
				ps.setString(1, a.getEmail());
				int updated_rows = ps.executeUpdate();

				if (updated_rows == 1) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean modificarUsuario(Usuario us) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("update usuario set name=?, password=? where email=?");
			ps.setString(1, us.getName());
			ps.setString(2, us.getPassword());
			ps.setString(3, us.getEmail());
			int updated_rows = ps.executeUpdate();

			if (updated_rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Usuario iniciarSesion(String email, String password) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from usuario where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return extractUserFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Libro> consultarFavoritos(Usuario us) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Usuario> consultaTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario consultaUsuario(String email) {
		Usuario usuario = null;
		try {

			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from usuario where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(rs.getString("name"), rs.getString("email"), rs.getString("password"),
						rs.getInt("admin"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	private Usuario extractUserFromResultSet(ResultSet rs) throws SQLException {
		Usuario user = new Usuario(rs.getString("name"), rs.getString("email"), rs.getString("password"), 0);
		
		return user;
	}
	public boolean esAdmin(String email) {
		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from usuario where email=? and admin=1");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean existeEmail(String email) {

		try {
			PreparedStatement ps = DatabaseConnection.connection.prepareStatement("select * from usuario where email =?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			
		}
		return false;
	}
	

}
