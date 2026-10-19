package ej12;

public class CajaDeAhorro extends Cuenta{
    private double comision;

    public CajaDeAhorro(){
        this.comision = 0.02;
    }

    private double calcularComision(double monto){
        return monto*this.comision;
    }

    private double calcularMontoFinal(double monto){
        return monto + calcularComision(monto);
    }

    @Override
    public void depositar(double monto){
        super.depositar(monto - this.calcularComision(monto));
    }

    @Override
    protected boolean puedeExtraer(double monto){
        return (calcularMontoFinal(monto) <= this.getSaldo());
    }

    @Override
    protected void extraerSinControlar(double monto){
        super.extraerSinControlar(calcularMontoFinal(monto));
    }

    @Override
    public boolean transferirACuenta(double monto, Cuenta cuentaDestino){
        if (cuentaDestino == null || cuentaDestino.equals(this)){
            return false;
        }
        if (!this.puedeExtraer(monto)){
            return false;
        }
        this.extraerSinControlar(monto);
        cuentaDestino.depositar(monto);
        return true;
    }
}