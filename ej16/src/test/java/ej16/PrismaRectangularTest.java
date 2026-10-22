package ej16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
    private static final double DELTA = 0.0001;
    private PrismaRectangular prisma;

    @BeforeEach
    void setUp(){
        prisma = new PrismaRectangular(10, 5, 3);
    }

    @Test
    void getVolumenTest(){
        assertEquals(150, prisma.getVolumen(), DELTA);
    }

    @Test
    void getSuperficieTest(){
        assertEquals(190, prisma.getSuperficie(), DELTA);
    }
}
