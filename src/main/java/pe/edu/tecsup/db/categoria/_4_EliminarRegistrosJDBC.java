package pe.edu.tecsup.db.categoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _4_EliminarRegistrosJDBC {

    public static void main(String[] args) {
        final String URL = "jdbc:mariadb://localhost/almacen2";
        final String USER = "root";
        final String PASSWORD = "root";

        try {
            // Cargar el driver
            Class.forName("org.mariadb.jdbc.Driver");

            // Conectarme a la Base de datos
            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

            // Preparar la sentencia
            String sql=
                    """
                    DELETE FROM  
                        categorias
                    WHERE 
                        id = ?;

                    """;
            PreparedStatement stmt= con.prepareStatement(sql);

            int id = 6;  // Set del ID del registro a eliminar

            // Preparar el Id del registro a eliminar
            stmt.setInt(1, id); // id del registro a eliminar

            // Ejecutar la eliminacion
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo eliminar el registro");

            System.out.printf("Se ha eliminado la categoria con id = %d \n", id);

            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.err.print(e);
        }
    }
}
