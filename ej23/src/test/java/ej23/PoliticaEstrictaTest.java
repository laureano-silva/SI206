package ej23;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PoliticaEstrictaTest {
    private static final double DELTA = 0.0001;

    /*
    montoReembolso(LocalDate inicio, LocalDate fechaCancelacion, double Precio)

    particiones: una sola, retorna siempre cero
     */

    @Test
    void montoReembolso_casoRepresentativo_retornaCero(){
        LocalDate fechaCancelacion = LocalDate.of(2026, 12, 6);
        LocalDate fechaInicio = LocalDate.of(2026, 12, 7);
        PoliticaCancelacion politica = new PoliticaEstricta();
        assertEquals(0, politica.montoReembolso(fechaInicio, fechaCancelacion, 150000), DELTA);
    }
}