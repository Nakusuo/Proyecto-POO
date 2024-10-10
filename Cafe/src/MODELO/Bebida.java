package MODELO;
import CONEXION.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bebida {
    private int id;
    private String nombre;
    private double precio;

    public Bebida(String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static List<Bebida> obtenerBebidas() {
        List<Bebida> bebidas = new ArrayList<>();
        String query = "SELECT * FROM bebidas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                bebidas.add(new Bebida(nombre, precio));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bebidas;
    }

    public static void agregarBebida(String nombre, double precio) {
        String query = "INSERT INTO bebidas (nombre, precio) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

