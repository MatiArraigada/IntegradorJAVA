package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {

    public static void  main(String[] args) {

        //leer archivo
        String resultadosFile = "..\\resultados.csv";
        Object[] lineas = null;
        try {
            lineas = Files.readAllLines(Paths.get(resultadosFile)).toArray();
            for (Object linea : lineas) {
                System.out.println(linea.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        for (int i = 0; i < lineas.length; i++) {
            String[] lineaI = lineas[i].toString().split(",");
            Partido partido1 = new Partido();
            Partido partido2 = new Partido();

            Equipo equipoI = new Equipo();
            equipoI.setNombre(lineaI[0]);
            equipoI.setGoles(Integer.parseInt(lineaI[1]));

            Equipo equipoII = new Equipo();
            equipoII.setNombre(lineaI[2]);
            equipoII.setGoles(Integer.parseInt(lineaI[3]));

            switch (i){
                case 0: {
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
                case 1: {
                    partido2.setEquipo1(equipoI);
                    partido2.setEquipo2(equipoII);
                    partido2.setGolesEquipo1(equipoI.getGoles());
                    partido2.setGolesEquipo2(equipoII.getGoles());
                    System.out.println("partido 2: " +
                            partido2.getEquipo1().getNomEquipo()+
                            " vs "+
                            partido2.getEquipo2().getNomEquipo());

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
            }


        }


    }
}