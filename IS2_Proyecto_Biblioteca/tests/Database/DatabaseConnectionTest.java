package tests.Database;

import static org.junit.Assert.*;
import org.junit.Test;


public class DatabaseConnectionTest {

    @Test
    public void testGetDatabase() {
        assertNotNull(Database.DatabaseConnection.getDatabase());
    }
}
