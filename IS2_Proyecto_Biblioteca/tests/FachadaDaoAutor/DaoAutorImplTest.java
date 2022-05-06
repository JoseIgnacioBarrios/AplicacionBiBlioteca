package tests.FachadaDaoAutor;

import static org.junit.Assert.*;

import java.util.List;

import Biblioteca.Model.Libro;
import Biblioteca.Model.Autor;
import org.junit.*;

public class DaoAutorImplTest {

    private static Autor autor;
    private static FachadaDaoAutor.DaoAutorImpl daoAutorImpl;

    @BeforeClass
    public static void SetUpClass() {
        Database.DatabaseConnection.getDatabase();
        daoAutorImpl = new FachadaDaoAutor.DaoAutorImpl();
    }

    @Before
    public void setUpBeforeEachTest() {
        autor = new Autor("test");
    }

    @Test
    public void testAltaAutor() {
        assertTrue(daoAutorImpl.altaAutor(autor));
    }


    @Test
    public void testConsultaAutor() {
        daoAutorImpl.altaAutor(autor);
        assertEquals(autor.getName(), daoAutorImpl.consultaAutor(autor.getName()).getName());
    }

    @Test
    public void testModificarAutor() {
        daoAutorImpl.altaAutor(autor);
        autor.setName("changed test name");
        assertTrue(daoAutorImpl.modificarAutor(autor, "test"));
        assertEquals("changed test name", daoAutorImpl.consultaAutor(autor.getName()).getName());
    }

    @Test
    public void testBuscarAutor() {
        daoAutorImpl.altaAutor(autor);
        Autor secondAutor = new Autor("second test name");
        daoAutorImpl.altaAutor(secondAutor);
        List<Autor> autors = daoAutorImpl.buscarAutor("test");
        assertEquals(autor.getName(), autors.get(0).getName());
        assertEquals(secondAutor.getName(), autors.get(1).getName());

        // clean up
        daoAutorImpl.bajaAutor(secondAutor.getName());
    }

    @Test
    public void testListaAutors() {
        daoAutorImpl.altaAutor(autor);
        Autor secondAutor = new Autor("second test name");
        daoAutorImpl.altaAutor(secondAutor);
        List<Autor> autors = daoAutorImpl.listaAutors();
        assertEquals(autor.getName(), autors.get(0).getName());
        assertEquals(secondAutor.getName(), autors.get(1).getName());

        // clean up
        daoAutorImpl.bajaAutor(secondAutor.getName());
    }

    @After
    public void tearDownAutor() {
        daoAutorImpl.bajaAutor(autor.getName());
    }

}
