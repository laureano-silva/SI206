package ej24;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreCompleto;
    private String domicilio;
    private ArrayList<Orden> ordenes;

    public Usuario(String nombreCompleto, String domicilio) {
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden (Orden orden){
        ordenes.add(orden);
    }

    public List<Orden> getOrdenes(){
        return List.copyOf(this.ordenes);
    }
}
