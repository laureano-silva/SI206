package ej12;

public class CuentaCorriente extends Cuenta{
    double descubierto;

    public CuentaCorriente(){
        this.descubierto = 0;
    }

    @Override
    protected boolean puedeExtraer(double monto){
        return (monto <= this.getSaldo() + descubierto);
    }

    public double getDescubierto(){return this.descubierto;}

    public void setDescubierto(double descubierto){
        this.descubierto = descubierto;
    }
}
