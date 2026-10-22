package ej16;

public class Esfera extends Pieza{
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    public double getVolumen(){
        return 4.0/3.0 * Math.PI * Math.pow(this.radio, 3);
    }

    public double getSuperficie(){
        return 4 * Math.PI * Math.pow(this.radio, 2);
    }
}
