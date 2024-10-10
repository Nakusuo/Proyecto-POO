package CONEXION;

   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos"; // Cambia esto
    private static final String USER = "tu_usuario"; // Cambia esto
    private static final String PASSWORD = "tu_contraseña"; // Cambia esto

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
