package ej25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    private Map<Jugador, Integer> mapaGoles;
    Jugador messi;
    Jugador aguero;
    Jugador bati;


    @BeforeEach
    void setUp(){
        mapaGoles = new HashMap<>();
        messi = new Jugador("Messi", "Lionel");
        bati = new Jugador("Batistuta", "Gabriel");
        aguero = new Jugador("Agüero", "Kun");
        mapaGoles.put(messi, 111);
        mapaGoles.put(bati, 56);
        mapaGoles.put(aguero, 42);
    }
    @Test
    void testEliminarEntrada(){
        assertTrue(mapaGoles.containsKey(aguero));
        int cantClaves = mapaGoles.size();
        mapaGoles.remove(aguero);
        assertFalse(mapaGoles.containsKey(aguero));
        assertEquals(cantClaves - 1, mapaGoles.size());
    }

    @Test
    void testActualizarEntrada(){
        assertEquals(111, mapaGoles.get(messi));
        assertEquals(111, mapaGoles.put(messi, 112)); // put retorna el valor anterior
        assertEquals(112, mapaGoles.get(messi));
    }

    @Test
    void testClaveNoSeRepite(){
        int cantClaves = mapaGoles.size();
        assertEquals(56, mapaGoles.put(new Jugador("Batistuta", "Gabriel"), 999));
        assertEquals(cantClaves, mapaGoles.size()); // la cantidad de claves no cambia
        assertEquals(999, mapaGoles.get(bati));
    }
}
