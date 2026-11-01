package ej23;

import DateLapse.DateLapse;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String nombre;
    private String direccion;
    private double precioPorNoche;
    private List<Reserva> reservas;
    private PoliticaCancelacion politicaCancelacion;

    public Propiedad(String nombre, String direccion, PoliticaCancelacion politicaCancelacion, double precioPorNoche){
        this.nombre = nombre;
        this.direccion = direccion;
        this.politicaCancelacion = politicaCancelacion;
        this.precioPorNoche = precioPorNoche;
        reservas = new ArrayList<>();
    }

    public boolean estaDisponible(DateLapse periodo){
        return this.reservas.stream()
                .noneMatch(reserva -> reserva.seSuperponeCon(periodo));
    }

    public Reserva crearReserva(DateLapse periodo){
        if (!estaDisponible(periodo)){
            return null;
        }
        Reserva reserva = new Reserva(this, periodo);
        this.reservas.add(reserva);
        return reserva;
    }

    public void borrarReserva(Reserva reserva){
        this.reservas.remove(reserva);
    }

    public double calcularIngresosPorPeriodo(DateLapse periodo){
        return this.reservas.stream()
                .filter(reserva -> reserva.seSuperponeCon(periodo))
                .mapToDouble(Reserva::calcularPrecio)
                .sum();
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public PoliticaCancelacion getPolitica() {
        return this.politicaCancelacion;
    }
}
