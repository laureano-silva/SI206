package ej15;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class InversionPlazoFijo implements Inversion{
    private LocalDate fechaConstitucion;
    private double montoDepositado;
    private double porcentajeInteresDiario;

    public InversionPlazoFijo(LocalDate fechaConstitucion, double montoDepositado, double porcentajeInteresDiario){
        this.fechaConstitucion = fechaConstitucion;
        this.montoDepositado = montoDepositado;
        this.porcentajeInteresDiario = porcentajeInteresDiario;
    }

    public double getValor(){
        long diasTranscurridos = ChronoUnit.DAYS.between(this.fechaConstitucion, LocalDate.now());
        return montoDepositado * (1 + diasTranscurridos * this.porcentajeInteresDiario);
    }
}
