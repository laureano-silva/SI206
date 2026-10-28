package ej22;

import DateLapse.DateLapse;

import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private String dni;
    private List<Reserva> reservas;
    private List<Propiedad> propiedades;

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

    public void cancelarReserva(Reserva reserva){
        if (reserva.cancelar()){
            this.reservas.remove(reserva);
        }
    }
}
