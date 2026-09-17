package ar.edu.unlp.info.oo1.ej07;
import java.time.LocalDate;
import java.util.List;

public class Ticket {
	LocalDate fecha;
	List<Producto> productos;
//	int cantidadDeProductos;
//	double pesoTotal;
//	double precioTotal;
	
	public Ticket(LocalDate fecha, List<Producto> productos){
		this.fecha = fecha;
		this.productos = productos;
	}

	public Double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public double getPesoTotal() {
		return productos.stream()
				.mapToDouble(Producto::getPeso)
				.sum();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public double getPrecioTotal() {
		return productos.stream()
				.mapToDouble(Producto::getPrecio)
				.sum();
	}
	public LocalDate getFecha() {return fecha;}
}
