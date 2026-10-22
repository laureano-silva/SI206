package ej16;

public class PrismaRectangular extends Pieza{
    private double ladoMayor;
    private double ladoMenor;
    private double altura;

    public PrismaRectangular(double ladoMayor, double ladoMenor, double altura) {
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    public double getVolumen(){
        return this.ladoMayor * this.ladoMenor * this.altura;
    }

    public double getSuperficie(){
        return 2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * this.altura);
    }
}
