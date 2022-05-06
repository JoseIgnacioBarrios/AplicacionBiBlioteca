package tests.FachadaDaoUsuario;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import Biblioteca.Model.Usuario;

public class DaoUsusarioImplTest {

    private static Usuario usuario;
    private static FachadaDaoUsuario.DaoUsuarioImpl daoUsuarioImpl;

    @BeforeClass
    public static void SetUpClass() {
        Database.DatabaseConnection.getDatabase();
        daoUsuarioImpl = new FachadaDaoUsuario.DaoUsuarioImpl();
    }

    @Before
    public void setUpBeforeEachTest() {
        usuario = new Usuario("test", "test@test.com", "test", 0);
    }

    @Test
    public void testRegistrarUsuario() {
        assertTrue(daoUsuarioImpl.registrarUsuario(usuario));
    }

    @Test
    public void testExisteUsuario() {
        daoUsuarioImpl.registrarUsuario(usuario);
        assertTrue(daoUsuarioImpl.existeUsuario(usuario.getEmail()));
    }

    @Test
    public void testIniciarsSession() {
        daoUsuarioImpl.registrarUsuario(usuario);
        assertEquals(usuario.getName(), daoUsuarioImpl.iniciarSesion(usuario.getEmail(), usuario.getPassword()).getName());
    }

    @Test
    public void testConsultaUsuario() {
        daoUsuarioImpl.registrarUsuario(usuario);
        assertEquals(usuario.getName(), daoUsuarioImpl.consultaUsuario(usuario.getEmail()).getName());
    }


    @Test
    public void testModificarUsuario() {
        daoUsuarioImpl.registrarUsuario(usuario);
        usuario.setName("changed test name");
        assertTrue(daoUsuarioImpl.modificarUsuario(usuario));
        assertEquals("changed test name", daoUsuarioImpl.consultaUsuario(usuario.getEmail()).getName());
    }

    @Test
    public void testEsAdmin() {
        usuario.setAdmin(1);
        daoUsuarioImpl.registrarUsuario(usuario);
        assertTrue(daoUsuarioImpl.esAdmin(usuario.getEmail()));
    }


    @After
    public void tearDownUsuario() {
        daoUsuarioImpl.deleteUsuario(usuario);
    }

}
