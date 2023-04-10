package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private int goles;
    private ResultadoEnum resultadoEnum;

    public ResultadoEnum getResultadoEnum() {
        return resultadoEnum;
    }

    public void setResultadoEnum(ResultadoEnum resultadoEnum) {
        this.resultadoEnum = resultadoEnum;
    }

    public String getNomEquipo() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
}