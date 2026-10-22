package ej16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
    private static final double DELTA = 0.0001;
    private Esfera esfera;

    @BeforeEach
    void setUp(){
        esfera = new Esfera(15);
    }

    @Test
    void getVolumenTest(){
        assertEquals(4500 * Math.PI, esfera.getVolumen(), DELTA);
    }

    @Test
    void getSuperficieTest(){
        assertEquals(900 * Math.PI, esfera.getSuperficie(), DELTA);
    }
}
