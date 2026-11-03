package ar.edu.unlp.info.oo1.ej07;

public class Producto {
	String descripcion;
	double peso;
	double precioPorKilo;

	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.descripcion = descripcion;
		this.peso = peso;
		this.precioPorKilo = precioPorKilo;
	}

	public Producto copiar() {
		// usado por Ticket para generar una lista con copias de los productos de Balanza
		return new Producto(this.descripcion, this.peso, this.precioPorKilo);
	}
	public double getPrecio(){
		return peso * precioPorKilo;
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecioPorKilo() {return precioPorKilo;}

	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
