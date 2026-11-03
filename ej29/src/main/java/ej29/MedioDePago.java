package ej29;

public interface MedioDePago {
    boolean autorizarPago(double monto);
    void pagar(double monto);
}
