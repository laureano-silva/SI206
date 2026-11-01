package ej23;

import java.time.LocalDate;

public class PoliticaFlexible implements PoliticaCancelacion{
    public double montoReembolso(LocalDate fechaInicio, LocalDate fechaCancelacion, double precio){
        return precio;
    }
}
