package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Conexion instance;
    private Connection connection;
    
    private Conexion() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost/gimnasio bd", "root", "");
            this.connection.setAutoCommit(false);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Conexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexion();
        } else if (instance.getConnection().isClosed()) {
            instance = new Conexion();
        }

        return instance;
    }

}