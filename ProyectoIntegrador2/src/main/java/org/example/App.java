package org.example.ProyectoIntegrador2.src.main.java.org.example;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class App 
{
    public static void main( String[] args )
    {
        String resultadosFile = "ProyectoIntegrador2\\src\\main\\resources\\resultados.csv";
        String pronosticoFile = "ProyectoIntegrador2\\src\\main\\resources\\pronostico.csv";
        String participante = "";
        int puntos = 0;
        Object[] lineas = null;
        Object[] lines = null;
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<org.example.Pronostico> pronosticos = new ArrayList<>();
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            lineas = Files.readAllLines(Paths.get(resultadosFile)).toArray();
            /*for (Object linea : lineas){
                System.out.println(linea.toString());
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < lineas.length; i++) {
            String[] linea = lineas[i].toString().split(",");
            int goles1 = Integer.parseInt(linea[2]);
            int goles2 = Integer.parseInt(linea[4]);
            Partido partido = new Partido(Integer.parseInt(linea[0]), linea[1], goles1, linea[3], goles2);
            if (goles1==goles2){
                partido.setResultado(ResultadoEnum.EMPATE);
            } else if (goles1>goles2) {
                partido.setResultado(ResultadoEnum.GANADOR);
            } else if (goles1<goles2) {
                partido.setResultado(ResultadoEnum.PERDEDOR);
            }
            partidos.add(partido);
        }
        try {
            lines = Files.readAllLines(Paths.get(pronosticoFile)).toArray();
            /*for (Object line : lines){
                System.out.println(line.toString());
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].toString().split(",");
            org.example.Pronostico pronostico = new org.example.Pronostico();
            Persona persona = new Persona();
            persona.setPersona(line[0]);
            pronostico.setParticipante(line[0]);
            if (!participante.equals(persona.getPersona())){
                personas.add(persona);
                participante= persona.getPersona();
            }
            pronostico.setRonda(Integer.parseInt(line[1]));
            pronostico.setEquipo1(line[2]);
            pronostico.setEquipo2(line[6]);
            if(line[3].equals("x")){
                pronostico.setResultado(ResultadoEnum.GANADOR);
            } else if (line[4].equals("x")) {
                pronostico.setResultado(ResultadoEnum.EMPATE);
            }else if (line[5].equals("x")){
                pronostico.setResultado(ResultadoEnum.PERDEDOR);
            }
            pronosticos.add(pronostico);
        }
      /*for (int i=0;i<partidos.size();i++) {
           System.out.println(partidos.get(i).getEquipo1()
                    +  " " + partidos.get(i).getGolesEquipo1()
                    +  " " + partidos.get(i).getEquipo2()
                    +  " " + partidos.get(i).getGolesEquipo2());
        }*/
        int pR = 0; //partidos por ronda
        for (int i=0; i< personas.size(); i++){
            for (int j= 0; j<partidos.size(); j++){
                if (pronosticos.get(j+pR).getResultado()==partidos.get(j).getResultado()){
                    puntos++;
                    personas.get(i).setPuntaje(puntos);
                }
            }
            pR=pR + partidos.size();
            puntos = 0;
            System.out.println("Puntos obtenidos por " + personas.get(i).getPersona() + " : " + personas.get(i).getPuntaje());
        }
    }
}
