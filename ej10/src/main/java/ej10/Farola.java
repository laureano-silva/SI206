package ej10;
import java.util.List;
import java.util.ArrayList;

public class Farola {
    private boolean encendida = false;
    private List<Farola> vecinas = new ArrayList<Farola>();

    public Farola(){
    }

    public boolean isOn(){
        return this.encendida;
    }

    public boolean isOff(){
        return !this.encendida;
    }

    public void turnOn(){
        if (this.isOn()){
            return;
        }
        this.encendida = true;
        for (Farola f : vecinas){
            f.turnOn();
        }
    }

    public void turnOff(){
        if (this.isOff()){
            return;
        }
        this.encendida = false;
        for (Farola f : vecinas){
            f.turnOff();
        }
    }

    public List<Farola> getNeighbors(){
        return List.copyOf(this.vecinas);
    }

    private void conectarVecina(Farola vecina){
        this.vecinas.add(vecina);
    }

    public void pairWithNeighbor(Farola otraFarola) {
        this.conectarVecina(otraFarola);
        otraFarola.conectarVecina(this);
    }
}
