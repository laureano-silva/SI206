package ej17;

import java.util.List;
import java.util.ArrayList;

public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre){
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void agregar(Email email){
        this.emails.add(email);
    }

    public void mover(Email email, Carpeta destino){
        destino.agregar(email);
        this.emails.remove(email);
    }

    public Email buscar(String texto){
        return this.emails.stream()
                .filter(mail -> mail.contiene(texto))
                .findFirst()
                .orElse(null);
    }

    public int espacioOcupado(){
        return this.emails.stream()
                .mapToInt(Email::tamano)
                .sum();
    }
}


