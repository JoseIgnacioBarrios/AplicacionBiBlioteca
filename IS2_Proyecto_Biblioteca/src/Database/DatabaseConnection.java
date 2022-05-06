package Database;

import java.sql.*;

public class DatabaseConnection {

    private final String url = System.getenv().getOrDefault("database_url", "jdbc:mysql://localhost:3306/Library"); 
    private final String user = System.getenv().getOrDefault("database_user", "root");
    private final String password = System.getenv().getOrDefault("database_password", "");
    private static DatabaseConnection database;
    public static Connection connection;
    
    private DatabaseConnection() {
    	try {
			DatabaseConnection.connection = initConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static DatabaseConnection getDatabase() {
    	// Esta Funcion hace de Singleton
    	if(database == null) {
    		database = new DatabaseConnection();
    	}  	
    	return database;
    }
    
    public Connection initConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.password);
    }
}