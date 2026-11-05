package ej24;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
    private LocalDate fecha;
    private String domicilio;
    private List<Producto> productos;

    public Orden(LocalDate fecha, String domicilio){
        this.fecha = fecha;
        this.domicilio = domicilio;
        this.productos = new ArrayList<>();
    }

    protected double calcularCostoProductos(){
        return this.productos.stream()
                .mapToDouble(Producto::getCosto)
                .sum();
    }

    public double calcularCosto(){
        double total = this.calcularCostoSinDescuento();
        if (aplicaDescuento()){
            return total * 0.9;
        }
        return total;
    }

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

    protected int cantidadProductos(){
        return this.productos.size();
    }

    protected abstract boolean aplicaDescuento();
    protected abstract double calcularCostoSinDescuento();
}
