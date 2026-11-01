package ej23;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PoliticaFlexibleTest {
    private static final double DELTA = 0.0001;

    /*
    montoReembolso(LocalDate inicio, LocalDate fechaCancelacion, double Precio)

    particiones: una sola, retorna siempre el precio de la reserva
     */

    @Test
    void montoReembolso_casoRepresentativo_retornaPrecio(){
        LocalDate fechaCancelacion = LocalDate.of(2026, 12, 6);
        LocalDate fechaInicio = LocalDate.of(2026, 12, 7);
        PoliticaCancelacion politica = new PoliticaFlexible();
        assertEquals(150000, politica.montoReembolso(fechaInicio, fechaCancelacion, 150000), DELTA);
    }
}