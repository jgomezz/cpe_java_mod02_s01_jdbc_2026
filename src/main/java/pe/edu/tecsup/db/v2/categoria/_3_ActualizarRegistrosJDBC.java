package pe.edu.tecsup.db.v2.categoria;

import pe.edu.tecsup.db.v2.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _3_ActualizarRegistrosJDBC {

    public static void main(String[] args) {

        try {

            // Conectarme a la Base de datos
            Connection con = DBConnection.getConnection();

            // Preparar la sentencia
            String sql=
                    """
                    UPDATE 
                        categorias
                    SET 
                        nombre= ?, descripcion= ?
                    WHERE 
                        id = ?;

                    """;
            PreparedStatement stmt= con.prepareStatement(sql);

            int id = 5;  // Set del ID del registro a modificar

            // Preparar los datos a actualizar por ID
            stmt.setString(1, "Dispositivo Móvil"); // nombre
            stmt.setString(2, "Descripción de Dispositivo Movil"); // descripcion
            stmt.setInt(3, id); // id del registro a modificar

            // Ejecutar la actualizacion
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo actualizar");

            System.out.printf("Se ha actualizado la categoria con id = %d \n", id);

            stmt.close();
            con.close();



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
