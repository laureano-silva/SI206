package ej23;

import java.time.LocalDate;

public interface PoliticaCancelacion {
    // la política asume que la llaman con valores anteriores al inicio, no valida fechas
    public double montoReembolso(LocalDate fechaInicio, LocalDate fechaCancelacion, double precio);
}
