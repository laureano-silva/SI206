package ej18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateLapseTest {
    private LocalDate from;
    private LocalDate to;
    private LocalDate other;
    DateLapse periodo;

    @BeforeEach
    void setUp(){
        // periodo del 01/11 al 10/11
        periodo = new DateLapse(LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 10));
    }

    // sizeInDays()

    @Test
    void sizeInDays_conFromIgualATo_retornaCero(){
        from = LocalDate.of(2026, 10, 26);
        to = LocalDate.of(2026, 10, 26);

        DateLapse periodo = new DateLapse(from, to);
        assertEquals(0, periodo.sizeInDays());
    }

    @Test
    void sizeInDays_conToMayorAFrom_retornaLaDiferenciaEnDias(){
        from = LocalDate.of(2026, 10, 26);
        to = LocalDate.of(2026, 10, 27);

        DateLapse periodo = new DateLapse(from, to);
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


