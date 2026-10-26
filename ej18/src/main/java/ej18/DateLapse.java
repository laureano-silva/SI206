package ej18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to){
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public int sizeInDays(){
        return Math.toIntExact(this.from.until(this.to, DAYS));
    }

    public boolean includesDate(LocalDate other){
        return(!other.isBefore(this.from) && !other.isAfter(this.to));
    }
}