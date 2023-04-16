package org.example.ProyectoIntegrador2.src.main.java.org.example;

import java.sql.*;

public class ConexionBD {
    public static void main(String[] args) {
        System.out.println("Resultados desde la Base de Datos SQL");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pronosticos",
                    "root",
                    "apolo1911"
            );
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery("select * from pronostico");
            while (rs.next()) {
                System.out.println("El/La participantes es: " + rs.getString(2));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


