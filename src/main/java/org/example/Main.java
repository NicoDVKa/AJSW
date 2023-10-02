package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
         try {
            /* Conexion con la base de datos */
            String jdbcUrl = "jdbc:postgresql://ep-delicate-salad-35504272.us-east-2.aws.neon.fl0.io:5432/postgres";
            String usuario = "fl0user";
            String contraseña = "y2tV3soJuTFA";
            Class.forName("org.postgresql.Driver");
            Connection conexión = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            /* Statement */
            Statement statement = conexión.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String consulta = "SELECT * FROM paises ";
            ResultSet resultado = statement.executeQuery(consulta);
            while (resultado.next()) {
                String id = resultado.getString("codigo_pais");
                String nombre = resultado.getString("nombre");
                System.out.println("Codigo: " + id + ", Nombre: " + nombre);
            }

            System.out.println("\n");

            /* Prepared Statement */
            PreparedStatement ps = conexión.prepareStatement(  "SELECT * FROM paises WHERE idioma = ? ",
                                                                   ResultSet.TYPE_FORWARD_ONLY,
                                                                   ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, "Inglés");
            ResultSet resultado1 = ps.executeQuery();
            while (resultado1.next()) {
                String id = resultado1.getString("codigo_pais");
                String nombre = resultado1.getString("nombre");
                System.out.println("Codigo: " + id + ", Nombre: " + nombre);
            }

            System.out.println("\n");
            /* Callable Statement */
            CallableStatement cs = conexión.prepareCall("{call obtener_info_pais(?)}",
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            cs.setString(1, "MEX");
            ResultSet resultado2 = cs.executeQuery();
            while (resultado2.next()) {
                String id = resultado2.getString("codigo_pais");
                String nombre = resultado2.getString("nombre");
                System.out.println("Codigo: " + id + ", Nombre: " + nombre);
            }

            resultado.close();
            statement.close();
            resultado1.close();
            ps.close();
            cs.close();
            resultado2.close();
            conexión.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
