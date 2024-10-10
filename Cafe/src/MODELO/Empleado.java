
package MODELO;

import CONEXION.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private int id;
    private String nombre;
    private String cargo;

    public Empleado(int id, String nombre, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public static List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cargo = rs.getString("cargo");
                empleados.add(new Empleado(id, nombre, cargo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public static void agregarEmpleado(String nombre, String cargo) {
        String query = "INSERT INTO empleados (nombre, cargo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, cargo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
