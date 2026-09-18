package ej06;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {
    String cliente;
    LocalDate fecha;
    List<Item> items;

    public Presupuesto(String cliente ){
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        items = new ArrayList<>();
    }

    public void agregarItem(Item item){
        this.items.add(item);
    }

    public Double calcularTotal(){
        return items.stream()
                .mapToDouble(Item::costo)
                .sum();
    }
}
