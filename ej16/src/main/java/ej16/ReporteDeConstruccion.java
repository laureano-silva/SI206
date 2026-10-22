package ej16;
import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion{
    private List<Pieza> piezas;

    public ReporteDeConstruccion(){
        this.piezas = new ArrayList<>();
    }

    public double volumenDeMaterial(String material){
        return piezas.stream()
                .filter(pieza -> pieza.getMaterial().equals(material))
                .mapToDouble(Pieza::getVolumen)
                .sum();
    }

    public double superficieDeColor(String color){
        return piezas.stream()
                .filter(pieza -> pieza.getColor().equals(color))
                .mapToDouble(Pieza :: getSuperficie)
                .sum();
    }
}
