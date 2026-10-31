package ej22;

import DateLapse.DateLapseByDates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    private Usuario usuario;
    private Propiedad propiedad;
    private Reserva reserva1;
    private Reserva reserva2;

    @BeforeEach
    void setUp(){
        usuario = new Usuario("John Doe", "123", "12345678");
        propiedad = new Propiedad("Las Marias", "Ejemplo 123", 120000);
    }

    /*
    crearReserva(Propiedad propiedad, DateLapse periodo)
    particiones: propiedad disponible y propiedad no disponible
    caso exitoso: se retorna la reserva y se suma a la lista de reservas del usuario
    caso fallido: se retorna null, la lista queda sin cambios
     */

    @Test
    void crearReserva_propiedadDisponible_agregaALaLista(){
        reserva1 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 8),
                LocalDate.of(2027, 1, 14)));

        assertTrue(usuario.getReservas().contains(reserva1));

        reserva2 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 31)));

        assertTrue(usuario.getReservas().contains(reserva1));
        assertTrue(usuario.getReservas().contains(reserva2));
    }

    @Test
    void crearReserva_propiedadNoDisponible_noAgregaALaLista(){
        reserva1 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 8),
                LocalDate.of(2027, 1, 14)));



        assertTrue(usuario.getReservas().contains(reserva1));
        assertEquals(1, usuario.getReservas().size()); // verif
    }

    /*
    cancelarReserva(Reserva reserva):
    particion 1: fecha < fecha de inicio de reserva, la reserva deja de estar en getReservas()
    particion 2: fecha >= fecha de inicio de reserva, no ocurren cambios
     */

    @Test
    void cancelarReserva_fechaAnteriorAlInicio_laSacaDeLaLista(){
        reserva1 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 8)));

        reserva2 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 10),
                LocalDate.of(2027, 1, 14)));

        // cancelo reserva2
        LocalDate fecha = LocalDate.of(2027, 1, 9);
        usuario.cancelarReserva(reserva2, fecha);

        assertFalse(usuario.getReservas().contains(reserva2)); // queda solamente reserva1
        assertTrue(usuario.getReservas().contains(reserva1));
        assertEquals(1, usuario.getReservas().size());
    }

    @Test
    void cancelarReserva_reservaEnCurso_sinCambios(){
        reserva1 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 8)));

        reserva2 = usuario.crearReserva(propiedad, new DateLapseByDates(
                LocalDate.of(2027, 1, 10),
                LocalDate.of(2027, 1, 14)));

        // cancelo reserva2
        LocalDate fecha = LocalDate.of(2027, 1, 10);
        usuario.cancelarReserva(reserva2, fecha);

        assertTrue(usuario.getReservas().contains(reserva2));
        assertEquals(2, usuario.getReservas().size());
    }
}
