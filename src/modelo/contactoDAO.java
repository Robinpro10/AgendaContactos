/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.conexionPhp;
import modelo.contacto;

public class contactoDAO {

//Inicio metodo agregar  contacto
    public boolean agregarContacto(contacto dato) {
        PreparedStatement ps = null;
        Connection con;
        con = getConexionPhp();
        String consulta = "INSERT INTO `contacto`( `nombre`, `sobreNombre`, `correo`, `celular`) VALUES ( ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getSobreNombre());
            ps.setString(3, dato.getCorreo());
            ps.setString(4, dato.getCelular());

            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
//fin metodo agregar  contacto

// Buscar usuario por Numero de celular a un contacto
    public boolean buscarEmpleado(contacto dato) {
        PreparedStatement ps = null;
        Connection con = getConexionPhp();
        ResultSet rs = null;
        String sql = "SELECT nombre, sobreNombre, correo, celular FROM contacto WHERE celular=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato.getCelular());
            rs = ps.executeQuery();
            if (rs.next()) {
                dato.setNombre(rs.getString("nombre"));
                dato.setNombre(rs.getString("sobreNombre"));
                dato.setNombre(rs.getString("correo"));
                dato.setNombre(rs.getString("celular"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }//Fin busqueda por Numero de celular a un contacto

//Inicio metodo modificar contacto
    public boolean modificarEmpleado(contacto dato) {
        PreparedStatement ps = null;
        Connection con = getConexionPhp();
        String sql = "update contacto set nombre=?,sobreNombre=?,correo=? where celular=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getSobreNombre());
            ps.setString(3, dato.getCorreo());
            ps.setString(4, dato.getCelular());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
//Fin metodo modificar contacto

//Inicio metodo eliminar  contacto
    public boolean EliminarContacto(contacto dato) {
        PreparedStatement ps = null;
        Connection con = getConexionPhp();
        String consulta = "delete from contacto where celular=?";
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, dato.getCelular());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }
//Fin metodo eliminar  contacto


//Obtener todos los registros de una tabla
    public ArrayList<contacto> obtenerRegistros() {
        ArrayList<contacto> registros = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection con = getConexionPhp();
        
        String query = "select c.nombre, c.sobreNombre, c.apellido, c.correo, c.direccion, c.fecha_nacimiento, c.telefono, e.Estado from contacto c ";
        try {
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String sobreNombre=resultSet.getString("sobreNombre");
                String correo=resultSet.getString("correo");
                String celular=resultSet.getString("celular");

                contacto registro = new contacto(nombre, sobreNombre, correo, celular);
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }//Fin obtener todos los registros de una tabla



    private Connection getConexionPhp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
