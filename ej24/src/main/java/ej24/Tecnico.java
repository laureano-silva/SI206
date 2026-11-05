package ej24;

public class Tecnico {
    private String nombreCompleto;
    private String especialidad;
    private double valorHora;

    public Tecnico(String nombreCompleto, String especialidad, double valorHora){
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.valorHora = valorHora;
    }

    public double calcularCosto(int horas){
        return horas * this.valorHora;
    }
}
