package ej29;

public class CuentaDNI implements MedioDePago{
    private String sucursal;
    private String numero;
    private double saldo;

    public boolean autorizarPago(double monto){
        return this.saldo >= monto;
    }

    public void pagar(double monto){
        this.saldo =- monto;
    }

}
