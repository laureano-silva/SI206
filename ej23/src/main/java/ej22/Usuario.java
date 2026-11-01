package ej22;

import DateLapse.DateLapse;
import ej23.Propiedad;
import ej23.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private String dni;
    private List<Reserva> reservas;
    private List<Propiedad> propiedades;

    public Usuario(String nombre, String direccion, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.reservas = new ArrayList<>();
        this.propiedades = new ArrayList<>();
    }

    public List<Reserva> getReservas(){
        return List.copyOf(this.reservas);
    }

    public double calcularRetribucion(DateLapse periodo){
        return this.propiedades.stream()
                .mapToDouble(propiedad -> propiedad.calcularIngresosPorPeriodo(periodo))
                .sum();
    }

    public Reserva crearReserva(Propiedad propiedad, DateLapse periodo){
        Reserva reserva = propiedad.crearReserva(periodo);
        if (reserva == null){return null;}
        this.reservas.add(reserva);
        return reserva;
    }

    public void cancelarReserva(Reserva reserva, LocalDate fecha){
        if (reserva.cancelar(fecha)){
            this.reservas.remove(reserva);
        }
    }
}
