package ej09;
import java.time.LocalDate;

public class Mamifero {
    String identificador;
    String especie;
    LocalDate fechaNacimiento;
    Mamifero padre;
    Mamifero madre;

    public Mamifero(String identificador){
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getAbueloMaterno(){
       return this.tieneMadre() ? this.getMadre().getPadre() : null;
    }

    public Mamifero getAbuelaMaterna(){
        return this.tieneMadre() ? this.getMadre().getMadre() : null;
    }

    public Mamifero getAbueloPaterno(){
        return this.tienePadre() ? this.getPadre().getPadre() : null;
    }

    public Mamifero getAbuelaPaterna(){
        return this.tienePadre() ? this.getPadre().getMadre() : null;
    }

    public boolean tienePadre(){return this.getPadre() != null;}

    public boolean tieneMadre(){return this.getMadre() != null;}

    public boolean tieneComoAncestroA(Mamifero mamifero) {
        if (this.tienePadre() && (getPadre() == mamifero || getPadre().tieneComoAncestroA(mamifero))) {
            return true;
        }
        if (this.tieneMadre() && (getMadre() == mamifero || getMadre().tieneComoAncestroA(mamifero))) {
            return true;
        }
        return false;
    }
}
