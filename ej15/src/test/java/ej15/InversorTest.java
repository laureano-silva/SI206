package ej15;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InversorTest {
    private Inversor inversor;
    private InversionAcciones accion;
    private InversionPlazoFijo plazoFijoDeAyer;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp(){
        inversor = new Inversor();
        accion = new InversionAcciones("GGAL", 1, 2.5);
        plazoFijoDeAyer = new InversionPlazoFijo(LocalDate.now().minusDays(1), 100, 0.01);
    }

    @Test
    void testAgregarInversion(){
        assertEquals(0, inversor.getValor(), DELTA);
        inversor.agregarInversion(accion); // valor = 2,50
        assertEquals(2.5, inversor.getValor(), DELTA);
    }

    @Test
    void testQuitarInversionExistente(){
        inversor.agregarInversion(accion); // valor = 2,50
        assertEquals(2.5, inversor.getValor(), DELTA);
        assertTrue(inversor.quitarInversion(accion));
        assertEquals(0, inversor.getValor(), DELTA);
    }

    @Test
    void testQuitarInversionInexistente(){
        inversor.agregarInversion(accion); // valor = 2,50
        assertEquals(2.5, inversor.getValor(), DELTA);
        assertFalse(inversor.quitarInversion(plazoFijoDeAyer));
        assertEquals(2.5, inversor.getValor(), DELTA);
    }

    @Test
    void testGetValorConInversionesMixtas(){
        inversor.agregarInversion(accion); // valor = 2,50
        inversor.agregarInversion(plazoFijoDeAyer); // valor = 101
        assertEquals(103.5, inversor.getValor(), DELTA);
    }

    @Test
    void testGetValorSinInversiones(){
        assertEquals(0, inversor.getValor(), DELTA);
    }
}
