package ej15;
import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private final List<Inversion> inversiones;

    public Inversor(){
        inversiones = new ArrayList<>();
    }

    public double getValor(){
        return inversiones.stream()
                .mapToDouble(Inversion::getValor)
                .sum();
    }

    public void agregarInversion(Inversion inversion){
        this.inversiones.add(inversion);
    }

    public boolean quitarInversion(Inversion inversion){
        return inversiones.remove(inversion);
    }
}
