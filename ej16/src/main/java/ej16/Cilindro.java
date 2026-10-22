package ej16;

public class Cilindro extends Pieza{
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura){
        this.radio = radio;
        this.altura = altura;
    }

    public double getVolumen(){
        return Math.PI * Math.pow(this.radio, 2) * this.altura;
    }

    public double getSuperficie(){
        return 2 * Math.PI * this.radio * (this.altura + this.radio);
    }
}
