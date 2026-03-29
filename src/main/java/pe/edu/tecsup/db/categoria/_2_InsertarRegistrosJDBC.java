package pe.edu.tecsup.db.categoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _2_InsertarRegistrosJDBC {

    public static void main(String[] args) {
        final String URL = "jdbc:mariadb://localhost/almacen2";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            // Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Conectarme a la Base de datos
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            con.close();


            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
