package ej29;

public class CuentaDNI implements MedioDePago{
    private String sucursal;
    private String numero;
    private double saldo;

    public CuentaDNI(String sucursal, String numero, double saldo) {
        this.sucursal = sucursal;
        this.numero = numero;
        this.saldo = saldo;
    }

    public boolean autorizarPago(double monto){
        return this.saldo >= monto;
    }

    public void pagar(double monto){
        this.saldo -= monto;
    }

}
