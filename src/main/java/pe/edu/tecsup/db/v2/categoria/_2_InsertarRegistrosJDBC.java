package pe.edu.tecsup.db.v2.categoria;

import pe.edu.tecsup.db.v2.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class _2_InsertarRegistrosJDBC {

    public static void main(String[] args) {

        try {

            // Conectarme a la Base de datos
            Connection con = DBConnection.getConnection();

            // TODO : Ingresar codigo faltante

            // Preparar la sentencia
            String sql=
                    """
                    INSERT INTO 
                        categorias (nombre, descripcion, orden)
                    VALUES (?,?,?);
                    """;
            PreparedStatement stmt= con.prepareStatement(sql);

            // Preparar los datos a Ingresar
            stmt.setString(1, "Portatiles");
            stmt.setString(2, "Portatiles de Gama Alta");
            stmt.setInt(3, 5);

            // Ejecutar la insercion
            int estado = stmt.executeUpdate();
            if (estado != 1)
                throw new SQLException("No se pudo insertar");

            // Obtener el ID del registro creado
            int id = 0;
            sql =
                """ 
                    SELECT last_insert_id()
                """;

            stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getInt(1);

            System.out.printf("Se inserto el registro de categoria con ID = %d \n", id);

            rs.close();
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
