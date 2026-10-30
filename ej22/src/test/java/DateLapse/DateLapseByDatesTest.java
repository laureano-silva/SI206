package DateLapse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class DateLapseByDatesTest {
    private DateLapseByDates dateLapse;

    @BeforeEach
    void setUp(){
        LocalDate inicio = LocalDate.of(2026, 10, 01);
        LocalDate fin = LocalDate.of(2026, 10, 31);
        dateLapse = new DateLapseByDates(inicio, fin);
    }

    /*
    overlaps():
    particion 1: iniciop y finp < inicio < fin, false, limite finp = inicio
    particion 2: iniciop < inicio < finp < fin, true, limite finp = inicio
    particion 3: inicio < iniciop < fin < finp, true, limite iniciop = fin
    particion 4: iniciop < inicio < fin < finp, true
    particion 5: inicio < iniciop < finp < fin, true
    particion 6: inicio < fin < iniciop < finp, false, limite iniciop = fin
     */

    @Test
    void overlaps_conPeriodoAnterior_daFalse(){
        LocalDate inicio = LocalDate.of(2026, 9, 15);
        LocalDate fin = LocalDate.of(2026, 9, 30);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertFalse(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_seSuperponeAlPrincipio_daTrue(){
        LocalDate inicio = LocalDate.of(2026, 9, 20);
        LocalDate fin = LocalDate.of(2026, 10, 15);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_seSuperponeAlFinal_daTrue(){
        LocalDate inicio = LocalDate.of(2026, 10, 15);
        LocalDate fin = LocalDate.of(2026, 11, 15);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_AincluidoDentroDeB_daTrue(){ //A es el periodo pasado por parametro
        LocalDate inicio = LocalDate.of(2026, 11, 10);
        LocalDate fin = LocalDate.of(2026, 11, 20);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_BincluidoDentroDeA_daTrue(){ //A es el periodo pasado por parametro
        LocalDate inicio = LocalDate.of(2026, 9, 25);
        LocalDate fin = LocalDate.of(2026, 11, 5);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_conPeriodoPosterior_daFalse(){
        LocalDate inicio = LocalDate.of(2026, 11, 1);
        LocalDate fin = LocalDate.of(2026, 11, 15);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertFalse(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_finCoincideConInicio_daTrue(){
        LocalDate inicio = LocalDate.of(2026, 9, 15);
        LocalDate fin = LocalDate.of(2026, 10, 1);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_inicioCoincideConFin_daTrue(){
        LocalDate inicio = LocalDate.of(2026, 10, 31);
        LocalDate fin = LocalDate.of(2026, 11, 15);
        DateLapse periodo = new DateLapseByDates(inicio, fin);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_coincidenInicioYFin_daTrue(){
        assertTrue(dateLapse.overlaps(dateLapse));
    }
}
