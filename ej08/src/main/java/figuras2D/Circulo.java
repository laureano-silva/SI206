package figuras2D;

public class Circulo implements Figura2D {
    double radio;

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return radio*2;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro * 0.5;
    }

    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }

    public double getArea() {
        return Math.PI * radio * radio;
    }
}
