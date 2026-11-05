package ej24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio extends Orden{
    private String descripcion;
    private int horas;
    private List<Tecnico> tecnicos;

    public OrdenServicio(LocalDate fecha, String domicilio, String descripcion, int horas){
        super(fecha, domicilio);
        this.descripcion = descripcion;
        this.horas = horas;
        this.tecnicos = new ArrayList<>();
    }

    public void agregarTecnico(Tecnico tecnico){
        this.tecnicos.add(tecnico);
    }

    private double calcularCostoManoDeObra(){
        return this.tecnicos.stream()
                .mapToDouble(tecnico -> tecnico.calcularCosto(horas))
                .sum();
    }

    public double calcularCostoSinDescuento(){
        return super.calcularCosto() + this.calcularCostoManoDeObra();
    }

    public boolean aplicaDescuento(){
        return this.horas > 10;
    }
}
