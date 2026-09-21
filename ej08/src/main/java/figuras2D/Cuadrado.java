package figuras2D;

public class Cuadrado implements Figura2D {
    double lado;

    public Cuadrado() {
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getPerimetro(){
        return lado * 4;
    };

    public double getArea(){
        return lado * lado;
    }
}