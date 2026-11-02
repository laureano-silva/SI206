package ej25;

import java.util.Objects;

public class Jugador {
    String apellido;
    String nombre;

    public Jugador(String apellido, String nombre){
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj){
        // si es la misma referencia
        if (this == obj){
            return true;
        }

        // si es nulo o de otra clase
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // casteo como ej25.Jugador
        Jugador otro = (Jugador) obj;
        return Objects.equals(this.apellido, otro.apellido)
                && Objects.equals(this.nombre, otro.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(apellido, nombre);
    }
}
