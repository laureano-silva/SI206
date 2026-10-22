package ej17;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmailTest {
    private Email email;

    @BeforeEach
    void setUp(){
        email = new Email("asunto", "prueba cuerpo"); // ocupa 19
    }

/*
    particiones de tamaño() según entrada:
    titulo: vacio/no vacio
    cuerpo: vacio/no vacio
    adjuntos: sin elementos/un elemento/varios elementos
    nombre de adjunto: vacio/no vacio
*/

    @Test
    void tamano_sinAdjuntos_sumaTituloYCuerpo(){
        assertEquals(19, email.tamano());
    }

    @Test
    void tamano_tituloYCuerpoVacios_esCero(){
        Email emailVacio = new Email("","");
        assertEquals(0, emailVacio.tamano());
    }

    @Test
    void tamano_conUnAdjunto_sumaElArchivo(){
        email.adjuntarArchivo(new Archivo("archivo ejemplo")); // ocupa 15
        assertEquals(19 + 15, email.tamano());
    }

    @Test
    void tamano_adjuntoConNombreVacio_noSuma(){
        email.adjuntarArchivo(new Archivo(""));
        assertEquals(19, email.tamano());
    }

    @Test
    void tamano_conVariosAdjuntos_sumaTodos(){
        email.adjuntarArchivo(new Archivo("un archivo")); // ocupa 10
        email.adjuntarArchivo(new Archivo("otro archivo")); // ocupa 12
        assertEquals(19 + 10 + 12, email.tamano());
    }

/*
    particiones de contiene() según entrada:
    titulo: coincide/no coincide
    cuerpo: coincide/no coincide
*/

    @Test
    void contiene_coincideElTitulo_esTrue(){
        assertTrue(email.contiene("asunto"));
    }

    @Test
    void contiene_coincideElCuerpo_esTrue(){
        assertTrue(email.contiene("prueba"));
    }

    @Test
    void contiene_coincidenTituloYCuerpo_esTrue(){
        Email otroEmail = new Email("prueba asunto", "prueba cuerpo");
        assertTrue(otroEmail.contiene("prueba"));
    }

    @Test
    void contiene_noCoincideTituloNiCuerpo_esFalse(){
        assertFalse(email.contiene("OO1"));
    }
}