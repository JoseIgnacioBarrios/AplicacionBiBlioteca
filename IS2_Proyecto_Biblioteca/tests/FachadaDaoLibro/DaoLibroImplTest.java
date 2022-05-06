package tests.FachadaDaoLibro;

import static org.junit.Assert.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Autor;
import org.junit.*;

public class DaoLibroImplTest {

    private static Libro libro;
    private static Autor autor;
    private static FachadaDaoLibro.DaoLibroImpl daoLibroImpl;
    private static FachadaDaoAutor.DaoAutorImpl daoAutorImpl;

    @BeforeClass
    public static void SetUpClass() {
        Database.DatabaseConnection.getDatabase();
        daoLibroImpl = new FachadaDaoLibro.DaoLibroImpl();
        daoAutorImpl = new FachadaDaoAutor.DaoAutorImpl();
        autor = new Autor("test");
        daoAutorImpl.altaAutor(autor);
    }

    @Before
    public void setUpBeforeEachTest() {
        libro = new Libro("1", "test", daoAutorImpl.consultaAutor(autor.getName()).getId(), "test", true);
    }

    @Test
    public void testAltaLibro() {
        assertTrue(daoLibroImpl.altaLibro(libro));
    }


    @Test
    public void testConsultaLibro() {
        daoLibroImpl.altaLibro(libro);
        assertEquals(libro.getTitulo(), daoLibroImpl.consultaLibro(libro.getISBN()).getTitulo());
    }

    @Test
    public void testModificarLibro() {
        daoLibroImpl.altaLibro(libro);
        libro.setTitulo("changed test title");
        assertTrue(daoLibroImpl.modificarLibro(libro));
        assertEquals("changed test title", daoLibroImpl.consultaLibro(libro.getISBN()).getTitulo());
    }

    @Test
    public void testBuscarLibro() {
        daoLibroImpl.altaLibro(libro);
        Libro secondLibro = new Libro("2", "second test book", daoAutorImpl.consultaAutor(autor.getName()).getId(), "test", true);
        daoLibroImpl.altaLibro(secondLibro);
        List<Libro> libros = daoLibroImpl.buscarLibro("test");
        assertEquals(libro.getTitulo(), libros.get(0).getTitulo());
        assertEquals(secondLibro.getTitulo(), libros.get(1).getTitulo());

        //clean up
        daoLibroImpl.bajaLibro(secondLibro.getISBN());
    }

    @Test
    public void testListaLibros() {
        daoLibroImpl.altaLibro(libro);
        Libro secondLibro = new Libro("2", "second test book", daoAutorImpl.consultaAutor(autor.getName()).getId(), "test", true);
        daoLibroImpl.altaLibro(secondLibro);
        List<Libro> libros = daoLibroImpl.listaLibros();
        assertEquals(libro.getTitulo(), libros.get(0).getTitulo());
        assertEquals(secondLibro.getTitulo(), libros.get(1).getTitulo());

        //clean up
        daoLibroImpl.bajaLibro(secondLibro.getISBN());
    }

    @After
    public void tearDownLibro() {
        daoLibroImpl.bajaLibro(libro.getISBN());
    }

    @AfterClass
    public static void TearDownClass() {
        daoAutorImpl.bajaAutor(autor.getName());
    }

}
