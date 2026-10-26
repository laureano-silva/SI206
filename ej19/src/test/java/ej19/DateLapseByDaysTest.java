package ej19;

import ej19.DateLapse;
import ej19.DateLapseByDays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateLapseByDaysTest {
    private LocalDate from;
    private LocalDate other;
    DateLapseByDays periodo;

    @BeforeEach
    void setUp(){
        // periodo del 01/11 al 10/11
        periodo = new DateLapseByDays(LocalDate.of(2026, 11, 1), 9);
    }

    // sizeInDays()

    @Test
    void sizeInDays_conFromIgualATo_retornaCero(){
        from = LocalDate.of(2026, 10, 26);

        DateLapseByDays periodo = new DateLapseByDays(from, 0);
        assertEquals(0, periodo.sizeInDays());
    }

    @Test
    void sizeInDays_conToMayorAFrom_retornaLaDiferenciaEnDias(){
        from = LocalDate.of(2026, 10, 26);

        DateLapseByDays periodo = new DateLapseByDays(from, 1);
        assertEquals(1, periodo.sizeInDays());
    }

    // includesDate(LocalDate other)

    @Test
    void includesDate_conFechaAnterior_esFalse(){
        other = LocalDate.of(2026, 10, 31);
        assertFalse(periodo.includesDate(other));
    }

    @Test
    void includesDate_conFechaIgualAFrom_esTrue(){
        other = LocalDate.of(2026, 11, 1);
        assertTrue(periodo.includesDate(other));
    }

    @Test
    void includesDate_conFechaMayorAFrom_esTrue(){
        other = LocalDate.of(2026, 11, 2);
        assertTrue(periodo.includesDate(other));
    }

    @Test
    void includesDate_conFechaMenorATo_esTrue(){
        other = LocalDate.of(2026, 11, 9);
        assertTrue(periodo.includesDate(other));
    }

    @Test
    void includesDate_conFechaIgualATo_esTrue(){
        other = LocalDate.of(2026, 11, 10);
        assertTrue(periodo.includesDate(other));
    }

    @Test
    void includesDate_conFechaMayorATo_esFalse(){
        other = LocalDate.of(2026, 11, 11);
        assertFalse(periodo.includesDate(other));
    }
}


