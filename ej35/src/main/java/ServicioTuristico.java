import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ServicioTuristico {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ServicioTuristico(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    protected long calcularDias(){
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    };

    public abstract double calcularCosto();
}
