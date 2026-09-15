package ar.edu.unlp.info.oo1.ej02;

public class Producto {
	String descripcion;
	double peso;
	double precioPorKilo;
	
	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.descripcion = descripcion;
		this.peso = peso;
		this.precioPorKilo= precioPorKilo;
	}

	public double getPrecio(){
		return peso * precioPorKilo;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecioPorKilo() {return precioPorKilo;}
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
