package org.example.ProyectoIntegrador2.src.main.java.org.example;

public class Partido {
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int ronda;
    private ResultadoEnum resultado;
    public Partido() {
    }
    public Partido(int ronda, String equipo1, int golesEquipo1, String equipo2, int golesEquipo2){
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.golesEquipo1 = golesEquipo1;
        this.equipo2 = equipo2;
        this.golesEquipo2 = golesEquipo2;
    }
    public String getEquipo1() {
        return equipo1;
    }
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }
    public String getEquipo2() {
        return equipo2;
    }
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
    public int getGolesEquipo1() {
        return golesEquipo1;
    }
    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }
    public int getGolesEquipo2() {
        return golesEquipo2;
    }
    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }
    public ResultadoEnum getResultado() {
        return resultado;
    }
    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
    public int getRonda() {
        return ronda;
    }
    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
}
