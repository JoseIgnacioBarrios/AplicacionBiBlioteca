package tests.FachadaDaoPelicula;

import static org.junit.Assert.*;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Pelicula;
import org.junit.*;

public class DaoPeliculaImplTest {

    private static Pelicula pelicula;
    private static FachadaDaoPelicula.DaoPeliculaImpl daoPeliculaImpl;

    @BeforeClass
    public static void SetUpClass() {
        Database.DatabaseConnection.getDatabase();
        daoPeliculaImpl = new FachadaDaoPelicula.DaoPeliculaImpl();
    }

    @Before
    public void setUpBeforeEachTest() {
        pelicula = new Pelicula("1", "test", 10, "test", true);
    }

    @Test
    public void testAltaPelicula() {
        assertTrue(daoPeliculaImpl.altaPelicula(pelicula));
    }


    @Test
    public void testConsultaPelicula() {
        daoPeliculaImpl.altaPelicula(pelicula);
        assertEquals(pelicula.getTitulo(), daoPeliculaImpl.consultaPelicula(pelicula.getISAN()).getTitulo());
    }

    @Test
    public void testModificarPelicula() {
        daoPeliculaImpl.altaPelicula(pelicula);
        pelicula.setTitulo("changed test name");
        assertTrue(daoPeliculaImpl.modificarPelicula(pelicula));
        assertEquals("changed test name", daoPeliculaImpl.consultaPelicula(pelicula.getISAN()).getTitulo());
    }

    @Test
    public void testBuscarPelicula() {
        daoPeliculaImpl.altaPelicula(pelicula);
        Pelicula secondPelicula = new Pelicula("1", "second test name", 10, "test", true);
        daoPeliculaImpl.altaPelicula(secondPelicula);
        List<Pelicula> peliculas = daoPeliculaImpl.buscarPelicula("test");
        assertEquals(pelicula.getTitulo(), peliculas.get(0).getTitulo());
        assertEquals(secondPelicula.getTitulo(), peliculas.get(1).getTitulo());

        // clean up
        daoPeliculaImpl.bajaPelicula(secondPelicula.getISAN());
    }

    @Test
    public void testListaPeliculas() {
        daoPeliculaImpl.altaPelicula(pelicula);
        Pelicula secondPelicula = new Pelicula("1", "second test name", 10, "test", true);
        daoPeliculaImpl.altaPelicula(secondPelicula);
        List<Pelicula> peliculas = daoPeliculaImpl.listaPeliculas();
        assertEquals(pelicula.getTitulo(), peliculas.get(0).getTitulo());
        assertEquals(secondPelicula.getTitulo(), peliculas.get(1).getTitulo());

        // clean up
        daoPeliculaImpl.bajaPelicula(secondPelicula.getISAN());
    }

    @After
    public void tearDownPelicula() {
        daoPeliculaImpl.bajaPelicula(pelicula.getISAN());
    }

}
