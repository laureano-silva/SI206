package DateLapse;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateLapseByDays implements DateLapse{
    private LocalDate from;
    private int sizeInDays;

    public DateLapseByDays(LocalDate from, int sizeInDays){
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.from.plusDays(sizeInDays);
    }

    public int sizeInDays(){
        return Math.toIntExact(this.from.until(this.getTo(), DAYS));
    }

    public boolean includesDate(LocalDate other){
        return(!other.isBefore(this.from) && !other.isAfter(this.getTo()));
    }

    public boolean overlaps(DateLapse other){
        return !other.getTo().isBefore(this.getFrom()) && !other.getFrom().isAfter(this.getTo());
    }
}