package ej15;

import java.time.LocalDate;

public class InversionAcciones implements Inversion{
    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public InversionAcciones(String nombre, int cantidad, double valorUnitario){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public double getValor(){
        return this.cantidad * this.valorUnitario;
    };
}
