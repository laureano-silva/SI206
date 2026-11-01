package ej23;

import DateLapse.DateLapse;
import java.time.LocalDate;

public class Reserva {
    private Propiedad propiedad;
    private DateLapse periodo;
    private double precio;
    private PoliticaCancelacion politica;

    public Reserva(Propiedad propiedad, DateLapse periodo){
        this.propiedad = propiedad;
        this.periodo = periodo;
        this.precio = propiedad.getPrecioPorNoche() * periodo.sizeInDays();
        this.politica = propiedad.getPolitica();
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public DateLapse getPeriodo() {
        return periodo;
    }

    public double calcularPrecio(){
        return this.precio;
    }

    public boolean estaEnCurso(LocalDate fecha){
        return this.periodo.includesDate(fecha);
    }

    public boolean seSuperponeCon(DateLapse periodo){
        return this.periodo.overlaps(periodo);
    }

    public boolean cancelar(LocalDate fecha){
        if (estaEnCurso(fecha)){return false;}
        this.propiedad.borrarReserva(this);
        return true;
    }

    public double montoReembolso(LocalDate fecha){
        if (!fecha.isBefore(this.periodo.getFrom())){
            return 0;
        }
        return this.politica.montoReembolso(this.periodo.getFrom(), fecha, this.calcularPrecio());
    }
}