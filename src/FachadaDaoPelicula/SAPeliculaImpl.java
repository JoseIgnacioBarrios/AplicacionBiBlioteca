package FachadaDaoPelicula;

import java.util.List;

import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;

public class SAPeliculaImpl implements ISAPelicula {

	IFachadaPeliculaDao ifPelicula = new FachadaPeliculaDaoImpl();
	
	@Override
	public boolean altaPelicula(Pelicula pelicula) {
		return ifPelicula.altaPelicula(pelicula);
	}

	public boolean bajaLibro(String ISBN) {
		// TODO Auto-generated method stub
		return ifPelicula.bajaPelicula(ISBN);
	}

	@Override
	public boolean modificarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return ifPelicula.modificarPelicula(pelicula);
	}

	@Override
	public Pelicula consultaPelicula(String ISBN) {
		// TODO Auto-generated method stub
		return ifPelicula.consultaPelicula(ISBN);
	}

	@Override
	public List<Pelicula> listaPeliculas() {
		// TODO Auto-generated method stub
		return ifPelicula.listaPeliculas();
	}

	@Override
	public boolean bajaPelicula(String ISBN) {
		// TODO Auto-generated method stub
		return ifPelicula.bajaPelicula(ISBN);
	}

	@Override
	public List<Pelicula> buscarPelicula(String titulo) {
		return ifPelicula.buscarPelicula(titulo);
	}

	@Override
	public boolean prestamoPelicula(String ISAN, Usuario usuario) {
		return ifPelicula.prestamoPelicula(ISAN, usuario);
	}

}
