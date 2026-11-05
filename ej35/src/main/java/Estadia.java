import java.time.LocalDate;

public class Estadia extends ServicioTuristico{
    private String destino;
    private double costoPorDia;
    private int cantidadPersonas;

    public Estadia(LocalDate fechaInicio, LocalDate fechaFin, String destino, double costoPorDia, int cantidadPersonas){
        super(fechaInicio, fechaFin);
        this.destino = destino;
        this.costoPorDia = costoPorDia;
        this.cantidadPersonas = cantidadPersonas;
    }

    public double calcularCosto(){
        return super.calcularDias() * this.costoPorDia * this.cantidadPersonas ;
    }
}
