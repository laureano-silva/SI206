package ej23;

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
    LocalDate fechaCancelacion;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp(){
        LocalDate inicio = LocalDate.of(2027, 1, 1);
        LocalDate fin = LocalDate.of(2027, 1, 6);
        periodo = new DateLapseByDates(inicio, fin);
        PoliticaCancelacion politica = new PoliticaFlexible();
        propiedad = new Propiedad("Las Marias", "Ejemplo 123", politica, 120000);
        reserva = propiedad.crearReserva(periodo);
    }

    /*
    cancelar(fecha):
    particion 1: fecha < periodo.inicio (reserva futura). devuelve true y se disponibiliza la propiedad. limite en fecha = periodo.inicio - 1
    particion 2: periodo.inicio <= fecha <= periodo.fin (reserva en curso). devuelve false y la propiedad sigue no disponible. limites en fecha = inicio, fecha = fin
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

    /*
    montoReembolso(LocalDate fecha)
    particiones:
    fecha < fechaInicio, devuelve reembolso según definido por la politica. Límite fecha = fechaInicio - 1
    fechaInicio <= fecha <= fechaFin, devuelve cero. Límite fecha = fechaInicio, fecha = fechaFin
    fecha > fechaFin, devuelve cero. Límite fecha = fechaFin + 1
     */

    @Test
    void montoReembolso_conUnMesDeAnticipacion_retornaMontoReembolso(){
        fechaCancelacion = reserva.getPeriodo().getFrom().minusDays(30);
        assertEquals(600000, reserva.montoReembolso(fechaCancelacion), DELTA); // 5 noches * 120,000
    }

    @Test
    void montoReembolso_con1DiaDeAnticipacion_retornaMontoReembolso(){
        fechaCancelacion = reserva.getPeriodo().getFrom().minusDays(1);
        assertEquals(600000, reserva.montoReembolso(fechaCancelacion), DELTA); // 5 noches * 120,000
    }

    @Test
    void montoReembolso_fechaCoincideConInicio_retornaCero(){
        fechaCancelacion = reserva.getPeriodo().getFrom();
        assertEquals(0, reserva.montoReembolso(fechaCancelacion), DELTA);
    }

    @Test
    void montoReembolso_fechaEntreInicioYFin_retornaCero(){
        fechaCancelacion = reserva.getPeriodo().getFrom().plusDays(1);
        assertEquals(0, reserva.montoReembolso(fechaCancelacion), DELTA);
    }

    @Test
    void montoReembolso_fechaCoincideConFin_retornaCero(){
        fechaCancelacion = reserva.getPeriodo().getTo();
        assertEquals(0, reserva.montoReembolso(fechaCancelacion), DELTA);
    }

    @Test
    void montoReembolso_fechaPosteriorAFin_retornaCero(){
        fechaCancelacion = reserva.getPeriodo().getTo().plusDays(1);
        assertEquals(0, reserva.montoReembolso(fechaCancelacion), DELTA);
    }

    @Test
    void montoReembolso_fechaMuyPosteriorAFin_retornaCero(){
        fechaCancelacion = reserva.getPeriodo().getTo().plusDays(30);
        assertEquals(0, reserva.montoReembolso(fechaCancelacion), DELTA);
    }

    // hace falta probar que un cambio de politica en Propiedad no afecte el calculo del reembolso?
}
