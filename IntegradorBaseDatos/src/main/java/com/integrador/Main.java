package com.integrador;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Conexion a MySQL");

        String participante = "";
        int puntos = 0;
        Object columna = null;
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<Pronostico> pronosticos = new ArrayList<>();
        ArrayList<Ronda> rondas = new ArrayList<>();
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pronostico",
                    "root",
                    "SqlDevs316"
            );
            PreparedStatement pstmt = null;
            ResultSet resultSet;
            pstmt = con.prepareStatement(
                    "SELECT * FROM partido");

            resultSet = pstmt.executeQuery("SELECT * FROM partido");        // Obtener tabla resultados de consulta   3
            while (resultSet.next()) {
                int goles1 = resultSet.getInt(3);
                int goles2 = resultSet.getInt(5);

                Partido partido = new Partido(
                        resultSet.getInt(1), //ronda
                        resultSet.getString(2), //equipo1
                        resultSet.getInt(3),//goles1
                        resultSet.getString(4), // equipo2
                        resultSet.getInt(5)); //goles 2
                if (goles1 == goles2) {
                    partido.setResultado(ResultadoEnum.EMPATE);
                } else if (goles1 > goles2) {
                    partido.setResultado(ResultadoEnum.GANADOR);
                } else if (goles1 < goles2) {
                    partido.setResultado(ResultadoEnum.PERDEDOR);
                }
                partidos.add(partido);

            }
            resultSet.close(); // Cerrar el conjunto de resultados       5
            pstmt.close(); // Cerrar PreparedStatement
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pronostico",
                    "root",
                    "SqlDevs316"
            );

            PreparedStatement pstmt2 = null;
            ResultSet resultSet2 = null;
            pstmt2 = conn.prepareStatement("SELECT * FROM pronosticopartido");
            resultSet2 = pstmt2.executeQuery("SELECT * FROM pronosticopartido");

            while (resultSet2.next()) {
                Pronostico pronostico = new Pronostico();
                Persona persona = new Persona();
                persona.setPersona(resultSet2.getString(7));
                pronostico.setParticipante(resultSet2.getString(7));

                if (!participante.equals(persona.getPersona())) {
                    personas.add(persona);
                    participante = persona.getPersona();
                }
                pronostico.setRonda(resultSet2.getInt(8));
                pronostico.setEquipo1(resultSet2.getString(2));
                pronostico.setEquipo2(resultSet2.getString(6));

                String ganador = resultSet2.getString(3);
                if (ganador.equals("x")) {
                    pronostico.setResultado(ResultadoEnum.GANADOR);
                } else if (resultSet2.getString(4).equals("x")) {
                    pronostico.setResultado(ResultadoEnum.EMPATE);
                } else if (resultSet2.getString(5).equals("x")) {
                    pronostico.setResultado(ResultadoEnum.PERDEDOR);
                }
                pronosticos.add(pronostico);
            }


            int pR = 0;
            for (int i = 0; i < personas.size(); i++) {
                for (int j = 0; j < partidos.size(); j++) {
                    if (pronosticos.get(j + pR).getResultado() == partidos.get(j).getResultado()) {
                        puntos++;
                        personas.get(i).setPuntaje(puntos);
                    }
                }
                pR = pR + partidos.size();
                puntos = 0;
                System.out.println("Puntos obtenidos por " + personas.get(i).getPersona() + " : " + personas.get(i).getPuntaje());



            }

            resultSet2.close(); // Cerrar el conjunto de resultados       5
            pstmt2.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}