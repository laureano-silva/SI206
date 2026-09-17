package ar.edu.unlp.info.oo1.ej07;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
	List<Producto> productos;
//	int cantidadDeProductos; ya no es necesario
//	double pesoTotal; ya no es necesario
//	double precioTotal; ya no es necesario

	public Balanza(){
		this.productos = new ArrayList<Producto>();
	}

	public Ticket emitirTicket(){
        return new Ticket(LocalDate.now(), this.productos);
	}

	public void agregarProducto(Producto producto){
		this.productos.add(producto);
//		this.cantidadDeProductos++;
//		this.precioTotal = this.precioTotal + producto.getPrecioPorKilo()*producto.getPeso();
//		this.pesoTotal = this.pesoTotal + producto.getPeso();
	}

	public void ponerEnCero(){
		this.productos.clear();
//		this.cantidadDeProductos = 0;
//		this.precioTotal = 0;
//		this.pesoTotal = 0;
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public double getPesoTotal() {
		return productos.stream()
				.mapToDouble(Producto::getPeso)
				.sum();
	}

	public double getPrecioTotal() {
		return productos.stream()
				.mapToDouble(Producto::getPrecio)
				.sum();
	}

	public List<Producto> getProductos(){
		return productos;
	}

}
