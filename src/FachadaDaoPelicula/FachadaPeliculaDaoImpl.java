package FachadaDaoPelicula;

import java.util.List;

import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;

public class FachadaPeliculaDaoImpl implements IFachadaPeliculaDao {

	IDaoPelicula iPelicula = new DaoPeliculaImpl();

	@Override
	public boolean altaPelicula(Pelicula pelicula) {
		return iPelicula.altaPelicula(pelicula);
	}

	@Override
	public boolean bajaPelicula(String ISBN) {
		// TODO Auto-generated method stub
		return iPelicula.bajaPelicula(ISBN);
	}

	@Override
	public boolean modificarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return iPelicula.modificarPelicula(pelicula);
	}

	@Override
	public Pelicula consultaPelicula(String ISBN) {
		// TODO Auto-generated method stub
		return iPelicula.consultaPelicula(ISBN);
	}

	@Override
	public List<Pelicula> listaPeliculas() {
		// TODO Auto-generated method stub
		return iPelicula.listaPeliculas();
	}

	@Override
	public List<Pelicula> buscarPelicula(String titulo) {
		return iPelicula.buscarPelicula(titulo);
	}

	@Override
	public boolean prestamoPelicula(String ISAN, Usuario usuario) {
		return iPelicula.prestamoPelicula(ISAN, usuario);
	}

}
