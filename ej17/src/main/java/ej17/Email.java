package ej17;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public Email(String titulo, String cuerpo){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public void adjuntarArchivo(Archivo archivo){
        this.adjuntos.add(archivo);
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getCuerpo(){
        return this.cuerpo;
    }

    public List<Archivo> adjuntos(){
        return this.adjuntos;
    }

    public int tamano(){
        int pesoAdjuntos = this.adjuntos.stream()
                .mapToInt(Archivo :: tamano)
                .sum();

        return this.titulo.length() + this.cuerpo.length() + pesoAdjuntos;
    }

    public boolean contiene(String texto){
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }

}
