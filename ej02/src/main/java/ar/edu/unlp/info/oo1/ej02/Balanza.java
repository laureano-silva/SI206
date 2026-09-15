package ar.edu.unlp.info.oo1.ej02;
import java.time.LocalDate;

public class Balanza {
	int cantidadDeProductos;
	double pesoTotal;
	double precioTotal;



	public Ticket emitirTicket(){
        return new Ticket(LocalDate.now(), this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
	}

	public void agregarProducto(Producto producto){
		this.cantidadDeProductos++;
		this.precioTotal = this.precioTotal + producto.getPrecioPorKilo()*producto.getPeso();
		this.pesoTotal = this.pesoTotal + producto.getPeso();
	}

	public void ponerEnCero(){
		this.cantidadDeProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

}
