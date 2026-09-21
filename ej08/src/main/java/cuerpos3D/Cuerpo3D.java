package cuerpos3D;

import figuras2D.Figura2D;

public class Cuerpo3D {
    Figura2D caraBasal;
    double altura;

    public Cuerpo3D() {
    }

    public void setCaraBasal(Figura2D caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getVolumen(){
        return caraBasal.getArea() * altura;
    }

    public double getSuperficieExterior(){
        return 2*caraBasal.getArea() + altura*caraBasal.getPerimetro();
    }
}
