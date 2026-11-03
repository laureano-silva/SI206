package ej29;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta implements MedioDePago{
    private String numero;
    private String titular;
    private LocalDate vencimiento;
    private double saldo;
    private List<Compra> compras;

    public Tarjeta(String numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        compras = new ArrayList<>();
    }

    public boolean autorizarPago(double monto){
        return this.saldo >= monto;
    }

    public void pagar(double monto){
        this.saldo =- monto;
    }

}
