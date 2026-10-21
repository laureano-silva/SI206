package ej15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class InversionPlazoFijoTest {
    private static final double DELTA = 0.0001;

    @Test
    void testGetValor(){
        InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(30), 100, 0.001);
        assertEquals(103, plazoFijo.getValor(), DELTA);
    }

    @Test
    void testGetValorCeroDias(){
        InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now(), 100, 0.001);
        assertEquals(100, plazoFijo.getValor(), DELTA);
    }

    @Test
    void testGetValorUnDia(){
        InversionPlazoFijo plazoFijo = new InversionPlazoFijo(LocalDate.now().minusDays(1), 100, 0.001);
        assertEquals(100.1, plazoFijo.getValor(), DELTA);
    }

    // se podrian implementar más tests para los valores borde y vecinos de monto e interés diario
}
