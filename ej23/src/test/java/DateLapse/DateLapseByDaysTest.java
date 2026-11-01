package DateLapse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class DateLapseByDaysTest {
    private DateLapseByDays dateLapse;

    @BeforeEach
    void setUp(){
        LocalDate inicio = LocalDate.of(2026, 10, 1);
        dateLapse = new DateLapseByDays(inicio, 30);
    }

    /*
    overlaps():
    particion 1: iniciop y finp < inicio < fin, false, limite finp = inicio - 1
    particion 2: iniciop < inicio < finp < fin, true, limite finp = inicio
    particion 3: inicio < iniciop < fin < finp, true, limite iniciop = fin
    particion 4: iniciop < inicio < fin < finp, true
    particion 5: inicio < iniciop < finp < fin, true
    particion 6: inicio < fin < iniciop < finp, false, limite iniciop = fin + 1
     */

    @Test
    void overlaps_otroTerminaElDiaAnteriorAlInicio_false(){
        LocalDate inicio = LocalDate.of(2026, 9, 15);
        DateLapse periodo = new DateLapseByDays(inicio, 15);
        assertFalse(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroEmpiezaAntesYTerminaDentro_true(){
        LocalDate inicio = LocalDate.of(2026, 9, 20);
        DateLapse periodo = new DateLapseByDays(inicio, 25);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroEmpiezaDentroYTerminaDespues_true(){
        LocalDate inicio = LocalDate.of(2026, 10, 15);
        DateLapse periodo = new DateLapseByDays(inicio, 30);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroContenidoEnReceptor_true(){ //A es el periodo pasado por parametro
        LocalDate inicio = LocalDate.of(2026, 10, 10);
        DateLapse periodo = new DateLapseByDays(inicio, 10);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroContieneAlReceptor_true(){ //A es el periodo pasado por parametro
        LocalDate inicio = LocalDate.of(2026, 9, 25);
        DateLapse periodo = new DateLapseByDays(inicio, 45);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroEmpiezaElDiaPosterioAlFin_false(){
        LocalDate inicio = LocalDate.of(2026, 11, 1);
        DateLapse periodo = new DateLapseByDays(inicio, 14);
        assertFalse(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroTerminaElDiaDeInicio_true(){
        LocalDate inicio = LocalDate.of(2026, 9, 28);
        DateLapse periodo = new DateLapseByDays(inicio, 3);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroEmpiezaElDiaDeFin_true(){
        LocalDate inicio = LocalDate.of(2026, 10, 31);
        DateLapse periodo = new DateLapseByDays(inicio, 15);
        assertTrue(dateLapse.overlaps(periodo));
    }

    @Test
    void overlaps_otroIgualAlReceptor_true(){
        LocalDate inicio = LocalDate.of(2026, 10, 1);
        DateLapse periodo = new DateLapseByDays(inicio, 30);
        assertTrue(dateLapse.overlaps(periodo));
    }
}
