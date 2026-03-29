package pe.edu.tecsup.db.v2.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class DBConnection {

    final static String URL = "jdbc:mariadb://localhost/almacen2";
    final static String USER = "root";
    final static String PASSWORD = "root";
    final static String DRIVER_NAME = "org.mariadb.jdbc.Driver";

    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection con = null;

        // Cargar el driver
        Class.forName(DRIVER_NAME);

        // Conectarme a la Base de datos
        con = DriverManager.getConnection(URL,USER,PASSWORD);


        return con;
    }

}
