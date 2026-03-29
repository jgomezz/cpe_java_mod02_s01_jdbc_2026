package pe.edu.tecsup.db.v2.categoria;

import pe.edu.tecsup.db.v2.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _1_ConsultarRegistrosJDBC {

    public static void main(String[] args) {

        try {

            // Conectarme a la Base de datos
            Connection con = DBConnection.getConnection();

            // Preparar la sentencia
            String sql=
                    """
                    SELECT
                    	id, nombre, descripcion, orden
                    FROM
                    	categorias;
                    """;
            PreparedStatement stmt= con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String desc = rs.getString("descripcion");

                System.out.printf("id = %d , nombre=%s , desc=%s \n", id,nombre,desc);
            }

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
