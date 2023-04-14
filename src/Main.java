package org.example.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void  main(String[] args) {

        //leer archivo
        String resultadosFile = "src/resultados.csv";
        Object[] lineas = null;

        try {
            lineas = Files.readAllLines(Paths.get(resultadosFile)).toArray();
            for (Object linea : lineas) {
                System.out.println(linea.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pronosticoFile = "src/pronostico.csv";
        Object[] lineas2 = null;

        try {
            lineas2 = Files.readAllLines(Paths.get(pronosticoFile)).toArray();
            for (Object linea2 : lineas2) {
                System.out.println(linea2.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Partido partidoI = new Partido();
        Partido partidoII = new Partido();
        Equipo teamI = new Equipo();
        Equipo teamII = new Equipo();
        Partido partido1 = new Partido();
        Partido partido2 = new Partido();
        Equipo equipoI = new Equipo();
        Equipo equipoII = new Equipo();
        int puntos = 0;
        for (int i = 1; i < lineas.length; i++) {
            String[] lineaI = lineas[i].toString().split(",");
            equipoI.setNombre(lineaI[0]);
            equipoI.setGoles(Integer.parseInt(lineaI[1]));
            equipoII.setNombre(lineaI[2]);
            equipoII.setGoles(Integer.parseInt(lineaI[3]));

            switch (i){
                case 1: {
                    partido1.setEquipo1(equipoI);
                    partido1.setEquipo2(equipoII);
                    partido1.setGolesEquipo1(equipoI.getGoles());
                    partido1.setGolesEquipo2(equipoII.getGoles());
                    System.out.println("partido 1: " +
                            partido1.getEquipo1().getNomEquipo() +
                            " vs " +
                            partido1.getEquipo2().getNomEquipo());
                    if(partido1.getGolesEquipo1()==partido1.getGolesEquipo2()){

                        equipoI.setResultadoEnum(ResultadoEnum.EMPATE);
                        equipoII.setResultadoEnum(ResultadoEnum.EMPATE);
                        System.out.println("empataron");

                    } else if (partido1.getGolesEquipo1()>partido1.getGolesEquipo2()) {
                        equipoI.setResultadoEnum(ResultadoEnum.GANADOR);
                        equipoII.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        System.out.println(equipoI.getNomEquipo() +" " + equipoI.getResultadoEnum());
                    }
                    else {
                        equipoII.setResultadoEnum(ResultadoEnum.GANADOR);
                        equipoI.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        System.out.println(equipoII.getNomEquipo() + " " + equipoII.getResultadoEnum());
                    }
                    break;
                }
                case 2: {
                    partido2.setEquipo1(equipoI);
                    partido2.setEquipo2(equipoII);
                    partido2.setGolesEquipo1(equipoI.getGoles());
                    partido2.setGolesEquipo2(equipoII.getGoles());
                    System.out.println("partido 2: " +
                            partido2.getEquipo1().getNomEquipo()+
                            " vs "+
                            partido2.getEquipo2().getNomEquipo());

                    if(partido2.getGolesEquipo1()==partido2.getGolesEquipo2()){

                        equipoI.setResultadoEnum(ResultadoEnum.EMPATE);
                        equipoII.setResultadoEnum(ResultadoEnum.EMPATE);
                        System.out.println("empataron");

                    } else if (partido2.getGolesEquipo1()>partido2.getGolesEquipo2()) {
                        equipoI.setResultadoEnum(ResultadoEnum.GANADOR);
                        equipoII.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        System.out.println(equipoI.getNomEquipo() +" " + equipoI.getResultadoEnum());
                    }
                    else {
                        equipoII.setResultadoEnum(ResultadoEnum.GANADOR);
                        equipoI.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        System.out.println(equipoII.getNomEquipo() + " " + equipoII.getResultadoEnum());
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < lineas2.length; i++) {
            String[] lineaII = lineas2[i].toString().split(",");

            String comparador = "x";
            teamI.setNombre(lineaII[0]);
            teamII.setNombre(lineaII[4]);

            switch (i){
                case 1: {
                    partidoI.setEquipo1(teamI);
                    partidoI.setEquipo2(teamII);

                    if (lineaII[1].equals(comparador)){
                        teamI.setResultadoEnum(ResultadoEnum.GANADOR);
                        teamII.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;

                        }
                    } else if (lineaII[2].equals(comparador)) {
                        teamI.setResultadoEnum(ResultadoEnum.EMPATE);
                        teamII.setResultadoEnum(ResultadoEnum.EMPATE);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;
                        }
                    }
                    else {
                        teamI.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        teamII.setResultadoEnum(ResultadoEnum.GANADOR);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;
                        }
                    }
                    break;
                    }
                case 2:{
                    partidoII.setEquipo1(teamI);
                    partidoII.setEquipo2(teamII);

                    if (lineaII[1].equals(comparador)){
                        teamI.setResultadoEnum(ResultadoEnum.GANADOR);
                        teamII.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;

                        }
                    } else if (lineaII[2].equals(comparador)) {
                        teamI.setResultadoEnum(ResultadoEnum.EMPATE);
                        teamII.setResultadoEnum(ResultadoEnum.EMPATE);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;
                        }
                    }
                    else if (lineaII[3].equals(comparador)){
                        teamI.setResultadoEnum(ResultadoEnum.PERDEDOR);
                        teamII.setResultadoEnum(ResultadoEnum.GANADOR);
                        if (teamI.getResultadoEnum().equals(equipoI.getResultadoEnum())){
                            puntos++;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Puntos obtenidos: " + puntos);
    }
}