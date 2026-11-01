package ej23;

import java.time.LocalDate;

public class PoliticaModerada implements PoliticaCancelacion{
    public double montoReembolso(LocalDate fechaInicio, LocalDate fechaCancelacion, double precio){
        if (!fechaCancelacion.isBefore(fechaInicio.minusDays(1))){
            return 0;
        }

        // reembolsa el 50% si se cancela entre los 6 y 2 días anteriores al inicio de la reserva
        LocalDate inicioPeriodoDevolucion50 = fechaInicio.minusDays(6); // menos una semana antes
        LocalDate finPeriodoDevolucion50 = fechaInicio.minusDays(2); // hasta dos dias antes
        if (!fechaCancelacion.isBefore(inicioPeriodoDevolucion50) && !fechaCancelacion.isAfter(finPeriodoDevolucion50)){
            return precio * 0.5;
        }

        // reembolsa el 100% si se cancela con hasta una semana de anticipación
        return precio;
    }
}