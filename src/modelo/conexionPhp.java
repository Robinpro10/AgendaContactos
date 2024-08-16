package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPhp {

    private String bd = "agendacontactos";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&serverTimezone=UTC";

    private Connection connection = null;

    public Connection conexionPhp() {
        try {
            // Cargar el driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Clase no encontrada");
            e.printStackTrace();
        }
        return connection;
    }
}

