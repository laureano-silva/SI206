package ej23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliticaModeradaTest {
    PoliticaCancelacion politica;
    LocalDate fechaInicio;
    LocalDate fechaCancelacion;
    double precio;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp(){
        politica = new PoliticaModerada();
        fechaInicio = LocalDate.of(2026, 12, 15);
        precio = 120000;
    }

    /*
    montoReembolso(LocalDate inicio, LocalDate fechaCancelacion, double Precio)

    particiones:
    devuelve el 100%: con fecha <= inicio - 7, valor limite en fecha = inicio - 7
    devuelve el 50%: con fecha > inicio - 7 y fecha <= inicio -2, valor limite en fecha = inicio - 6 y fecha = inicio -2
    devuelve 0: con fecha = inicio - 1
    (politica no se encarga de validar que fecha < inicio)
     */

    @Test
    void montoReembolso_conUnMesDeAnticipacion_reembolsaTodo(){
        fechaCancelacion = fechaInicio.minusDays(30);
        assertEquals(120000, politica.montoReembolso(fechaInicio, fechaCancelacion, precio), DELTA);
    }

    @Test
    void montoReembolso_con7DiasDeAnticipacion_reembolsaTodo(){
        fechaCancelacion = fechaInicio.minusDays(7);
        assertEquals(120000, politica.montoReembolso(fechaInicio, fechaCancelacion, precio), DELTA);
    }

    @Test
    void montoReembolso_con6DiasDeAnticipacion_reembolsaLaMitad(){
        fechaCancelacion = fechaInicio.minusDays(6);
        assertEquals(60000, politica.montoReembolso(fechaInicio, fechaCancelacion, precio), DELTA);
    }

    @Test
    void montoReembolso_con2DiasDeAnticipacion_reembolsaLaMitad(){
        fechaCancelacion = fechaInicio.minusDays(2);
        assertEquals(60000, politica.montoReembolso(fechaInicio, fechaCancelacion, precio), DELTA);
    }

    @Test
    void montoReembolso_con1DiaDeAnticipacion_noReembolsa(){
        fechaCancelacion = fechaInicio.minusDays(1);
        assertEquals(0, politica.montoReembolso(fechaInicio, fechaCancelacion, precio), DELTA);
    }
}
