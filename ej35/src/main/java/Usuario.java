import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<ServicioTuristico> servicios;

    public Usuario(String nombre){
        this.nombre = nombre;
        servicios = new ArrayList<>();
    }

    public void agregarServicio(ServicioTuristico servicio){
        this.servicios.add(servicio);
    }

    public double calcularGastoTotal(){
        return this.servicios.stream()
                .mapToDouble(ServicioTuristico::calcularCosto)
                .sum();
    }
}
