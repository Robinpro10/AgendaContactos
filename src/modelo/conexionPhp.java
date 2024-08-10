/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author uptc-
 */
public class conexionPhp {

    private String bd="agendacontactos";
    private String user="root";
    private String password="";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private Connection connection=null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("bien");
        }catch(SQLException e){
            System.err.println(e);    
            System.out.println("mal, error entre la silla y el pc:c");
        } catch (ClassNotFoundException e){
            java.util.logging.Logger.getLogger(conexionPhp.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        return connection;
    }
    
}
