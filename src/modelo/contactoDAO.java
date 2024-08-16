package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactoDAO extends ConexionPhp {

    private final String[] columnas = {"Identificación", "Nombre", "Apellido", "Fecha Nacimiento", "Correo", "Direccion", "Estado"};

    // Método para agregar contacto a la base de datos
    public boolean agregarContacto(Contacto dato) {
        String consulta = "INSERT INTO contacto (nombre, sobreNombre, correo, celular) VALUES (?, ?, ?, ?)";
        try (Connection con = conexionPhp(); PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getSobreNombre());
            ps.setString(3, dato.getCorreo());
            ps.setString(4, dato.getCelular());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al agregar contacto: " + e.getMessage());
            return false;
        }
    }

    // Método para buscar contacto por número de celular
    public boolean buscarContacto(Contacto dato) {
        String sql = "SELECT nombre, sobreNombre, correo, celular FROM contacto WHERE celular=?";
        try (Connection con = conexionPhp(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dato.getCelular());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dato.setNombre(rs.getString("nombre"));
                    dato.setSobreNombre(rs.getString("sobreNombre"));
                    dato.setCorreo(rs.getString("correo"));
                    dato.setCelular(rs.getString("celular"));
                    return true;
                }
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar contacto: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar contacto
    public boolean modificarContacto(Contacto dato) {
        String sql = "UPDATE contacto SET nombre=?, sobreNombre=?, correo=? WHERE celular=?";
        try (Connection con = conexionPhp(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getSobreNombre());
            ps.setString(3, dato.getCorreo());
            ps.setString(4, dato.getCelular());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al modificar contacto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar contacto
    public boolean eliminarContacto(Contacto dato) {
        String consulta = "DELETE FROM contacto WHERE celular=?";
        try (Connection con = conexionPhp(); PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, dato.getCelular());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar contacto: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los registros de la tabla de contactos
    public ArrayList<Contacto> obtenerRegistros() {
        ArrayList<Contacto> registros = new ArrayList<>();
        String query = "SELECT nombre, sobreNombre, correo, celular FROM contacto";
        try (Connection con = conexionPhp(); PreparedStatement statement = con.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String sobreNombre = resultSet.getString("sobreNombre");
                String correo = resultSet.getString("correo");
                String celular = resultSet.getString("celular");

                Contacto registro = new Contacto(nombre, sobreNombre, correo, celular);
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener registros: " + e.getMessage());
        }
        return registros;
    }

}
