package ej29;

public class SUBE {
    private double saldo;

    public boolean autorizarPago(double monto){
        return this.saldo >= monto;
    }

    public void pagar(double monto){
        this.saldo -= monto;
    }

    public boolean recargar(double monto, MedioDePago medioDePago){
        if (!medioDePago.autorizarPago(monto)){
            return false;
        }
        medioDePago.pagar(monto);
        this.saldo += monto;
        return true;
    }
}
