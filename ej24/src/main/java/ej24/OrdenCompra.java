package ej24;

import java.time.LocalDate;

public class OrdenCompra extends Orden{
    private double precioEnvio;

    public OrdenCompra(LocalDate fecha, String domicilio, double precioEnvio){
        super(fecha, domicilio);
        this.precioEnvio = precioEnvio;
    }

    protected boolean aplicaDescuento(){
        return this.cantidadProductos() >= 5;
    }

    protected double calcularCostoSinDescuento(){
        return super.calcularCostoProductos() + this.precioEnvio;
    }
}
