import java.time.LocalDate;

public class AlquilerAuto extends ServicioTuristico{
    private double costoPorKm;
    private double kmRecorridos;
    private double costoDiarioSeguro;
    private String tipoVehiculo;

    public AlquilerAuto(LocalDate fechaInicio, LocalDate fechaFin, double costoPorKm, double kmRecorridos, double costoDiarioSeguro, String tipoVehiculo) {
        super(fechaInicio, fechaFin);
        this.costoPorKm = costoPorKm;
        this.kmRecorridos = kmRecorridos;
        this.costoDiarioSeguro = costoDiarioSeguro;
        this.tipoVehiculo = tipoVehiculo;
    }

    public double calcularCosto(){
        return (this.kmRecorridos * this.costoPorKm) + (this.costoDiarioSeguro * super.calcularDias());
    }
}
