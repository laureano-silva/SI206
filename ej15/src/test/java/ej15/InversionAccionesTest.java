package ej15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InversionAccionesTest {
    private static final double DELTA = 0.0001;

    @Test
    void testGetValor(){
        InversionAcciones accion = new InversionAcciones("GGAL", 10, 2.5);
        assertEquals(25, accion.getValor(), DELTA);
    }

    @Test
    void testGetValorConCantidadCero(){
        InversionAcciones accion = new InversionAcciones("GGAL", 0, 2.5);
        assertEquals(0.0, accion.getValor(), DELTA);
    }

    @Test
    void testGetValorConCantidadUno(){
        InversionAcciones accion = new InversionAcciones("GGAL", 1, 2.5);
        assertEquals(150.0, accion.getValor(), DELTA);
    }

    @Test
    void testGetValorConValorUnitarioCero(){
        InversionAcciones accion = new InversionAcciones("GGAL", 10, 0.0);
        assertEquals(0.0, accion.getValor(), DELTA);
    }
}