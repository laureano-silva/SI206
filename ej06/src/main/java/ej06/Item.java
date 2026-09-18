package ej06;

public class Item {
    String detalle;
    int cantidad;
    double costoUnitario;

    public Item(String detalle, int cantidad, double costoUnitario){
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public Double costo(){
        return costoUnitario * cantidad;
    }
}
