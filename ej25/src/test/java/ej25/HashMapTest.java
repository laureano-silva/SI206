package ej25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private Map<String, Integer> mapaGoles;

    @BeforeEach
    void setUp(){
        mapaGoles = new HashMap<>();
        mapaGoles.put("Lionel Messi", 111);
        mapaGoles.put("Gabriel Batistuta", 56);
        mapaGoles.put("Kun Agüero", 42);
    }
    @Test
    void testEliminarEntrada(){
        assertTrue(mapaGoles.containsKey("Kun Agüero"));
        int cantClaves = mapaGoles.size();
        mapaGoles.remove("Kun Agüero");
        assertFalse(mapaGoles.containsKey("Kun Agüero"));
        assertEquals(cantClaves - 1, mapaGoles.size());
    }

    @Test
    void testActualizarEntrada(){
        assertEquals(111, mapaGoles.get("Lionel Messi"));
        assertEquals(111, mapaGoles.put("Lionel Messi", 112)); // put retorna el valor anterior
        assertEquals(112, mapaGoles.get("Lionel Messi"));
    }

    @Test
    void testClaveNoSeRepite(){
        int cantClaves = mapaGoles.size();
        assertEquals(56, mapaGoles.put("Gabriel Batistuta", 999));
        assertEquals(cantClaves, mapaGoles.size()); // la cantidad de claves no cambia
        assertEquals(999, mapaGoles.get("Gabriel Batistuta"));

    }

}
