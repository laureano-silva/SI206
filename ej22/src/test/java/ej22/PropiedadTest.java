package ej22;

import DateLapse.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PropiedadTest {
    private Propiedad propiedad;
    private Reserva reserva3;
    private DateLapse periodo;

    @BeforeEach
    void setUp(){
        propiedad = new Propiedad("Las Marias", "Ejemplo 123", 120000);

        periodo = new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 7));
    }

    /*
    estaDisponible(DateLapse periodo)
    estados lista: lista vacia, lista con 1 reserva, lista con varias reservas
    estados periodo: se superpone, no se superpone (los limites ya estan testeado en DateLapse)
    */

    @Test
    void estaDisponible_listaDeReservasVacia_true(){
        assertTrue(propiedad.estaDisponible(periodo));
    }

    @Test
    void estaDisponible_existeReservaQueCoincide_false(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 14)));
        assertFalse(propiedad.estaDisponible(periodo));
    }

    @Test
    void estaDisponible_existeReservaQueNoCoincide_true(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 21)));
        assertTrue(propiedad.estaDisponible(periodo));
    }

    @Test
    void estaDisponible_multiplesReservasUnaCoincide_false(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 21)));

        //reserva que coincide
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 14)));

        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 22),
                LocalDate.of(2027, 1, 31)));

        assertFalse(propiedad.estaDisponible(periodo));
    }

    @Test
    void estaDisponible_multiplesReservasNingunaCoincide_true(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 8),
                LocalDate.of(2027, 1, 14)));

        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 21)));

        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 22),
                LocalDate.of(2027, 1, 31)));

        assertTrue(propiedad.estaDisponible(periodo));
    }

    /*
    crearReserva(DateLapse periodo)
    particiones: propiedad disponible -> retorna la reserva, y propiedad no disponible -> null
    caso exitoso: verificar que ademas de retornar la reserva se agrega a la lista
    caso fallido: verificar que la lista no se modifica
     */

    @Test
    void crearReserva_propiedadEstaDisponible_retornaReservaYQuedaOcupada(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 8),
                LocalDate.of(2027, 1, 14)));

        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 21)));

        // creo reserva con periodo 01/01 al 07/01
        assertNotNull(propiedad.crearReserva(periodo));
        assertFalse(propiedad.estaDisponible(periodo));

        // verifico que las demas reservas siguen existiendo
        assertFalse(propiedad.estaDisponible(new DateLapseByDates(
                LocalDate.of(2027, 1, 9),
                LocalDate.of(2027, 1, 13))));

        assertFalse(propiedad.estaDisponible(new DateLapseByDates(
                LocalDate.of(2027, 1, 16),
                LocalDate.of(2027, 1, 20))));

    }

    @Test
    void crearReserva_propiedadNoEstaDisponible_retornaNullYQuedaDisponible(){
        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 6),
                LocalDate.of(2027, 1, 14)));

        propiedad.crearReserva(new DateLapseByDates(
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2027, 1, 21)));

        // creo reserva con periodo 01/01 al 07/01, se superpone al final
        assertNull(propiedad.crearReserva(periodo));

        // compruebo que no se creo la reserva, verificando que los primeros dias estan disponibles
        assertTrue(propiedad.estaDisponible(new DateLapseByDates(
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 5))));
    }
}
