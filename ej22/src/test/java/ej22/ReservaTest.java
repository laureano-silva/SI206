package ej22;

import DateLapse.DateLapse;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import DateLapse.DateLapseByDates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {
    private Reserva reserva;
    private Propiedad propiedad;
    private DateLapse periodo;

    @BeforeEach
    void setUp(){
        LocalDate inicio = LocalDate.of(2027, 1, 1);
        LocalDate fin = LocalDate.of(2027, 1, 6);
        periodo = new DateLapseByDates(inicio, fin);
        propiedad = new Propiedad("Las Marias", "Ejemplo 123", 120000);
        reserva = propiedad.crearReserva(periodo);
    }

    /*
    cancelar(fecha):
    particion 1: fecha < periodo.inicio (reserva futura). devuelve true y se disponibiliza la propiedad. limite en fecha = periodo.inicio - 1
    particion 2:  periodo.inicio <= fecha <= periodo.fin (reserva en curso). devuelve false y la propiedad sigue no disponible. limites en fecha = inicio, fecha = fin
    se asume que no se intentan cancelar reservas pasadas.
     */

    @Test
    void cancelar_diaAnteriorAlInicio_true(){
        LocalDate fechaCancelacion = LocalDate.of(2026, 12, 31);
        assertTrue(reserva.cancelar(fechaCancelacion));
        assertTrue(reserva.getPropiedad().estaDisponible(reserva.getPeriodo()));
    }

    @Test
    void cancelar_diaDentroDelPeriodo_false(){
        LocalDate fechaCancelacion = LocalDate.of(2027, 1, 3);
        assertFalse(reserva.cancelar(fechaCancelacion));
        assertFalse(reserva.getPropiedad().estaDisponible(reserva.getPeriodo()));
    }

    @Test
    void cancelar_diaIgualAlInicio_false(){
        LocalDate fechaCancelacion = LocalDate.of(2027, 1, 1);
        assertFalse(reserva.cancelar(fechaCancelacion));
        assertFalse(reserva.getPropiedad().estaDisponible(reserva.getPeriodo()));
    }

    @Test
    void cancelar_diaIgualAlFin_false(){
        LocalDate fechaCancelacion = LocalDate.of(2027, 1, 6);
        assertFalse(reserva.cancelar(fechaCancelacion));
        assertFalse(reserva.getPropiedad().estaDisponible(reserva.getPeriodo()));
    }
}
