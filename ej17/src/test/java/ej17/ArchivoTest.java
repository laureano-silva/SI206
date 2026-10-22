package ej17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ArchivoTest {

    @Test
    void tamanoTest(){
        Archivo archivo = new Archivo("prueba");
        assertEquals(6, archivo.tamano());
    }
}
