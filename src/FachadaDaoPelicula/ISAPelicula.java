package FachadaDaoPelicula;

import java.util.List;

import Biblioteca.Model.Pelicula;
import Biblioteca.Model.Usuario;

public interface ISAPelicula {
	public boolean altaPelicula(Pelicula pelicula);
	public boolean bajaPelicula(String ISBN);
	public boolean modificarPelicula(Pelicula pelicula);
	public Pelicula consultaPelicula(String ISBN);
	public List<Pelicula> buscarPelicula(String titulo);
	public List<Pelicula> listaPeliculas();	
	public boolean prestamoPelicula(String ISAN, Usuario usuario);
}
