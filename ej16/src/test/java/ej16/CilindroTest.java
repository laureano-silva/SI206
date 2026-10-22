package ej16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {
    private static final double DELTA = 0.0001;
    private Cilindro cilindro;

    @BeforeEach
    void setUp(){
        cilindro = new Cilindro(2, 10);
    }

    @Test
    void getVolumenTest(){
        assertEquals(40 * Math.PI, cilindro.getVolumen(), DELTA);
    }

    @Test
    void getSuperficieTest(){
        assertEquals(48 * Math.PI, cilindro.getSuperficie(), DELTA);
    }
}
