package ej22;

import DateLapse.DateLapse;
import java.time.LocalDate;

public class Reserva {
    private Propiedad propiedad;
    private DateLapse periodo;

    public Reserva(Propiedad propiedad, DateLapse periodo){
        this.propiedad = propiedad;
        this.periodo = periodo;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public DateLapse getPeriodo() {
        return periodo;
    }

    public double calcularPrecio(){
        return this.periodo.sizeInDays() * this.propiedad.getPrecioPorNoche();
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
}
