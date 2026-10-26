## Ejercicio 18: Intervalo de tiempo
En Java, las fechas se representan normalmente con instancias de la clase java.time.LocalDate. Se pueden crear con varios métodos "static" como por ejemplo LocalDate.now().

- Investigue cómo hacer para crear una fecha determinada, por ejemplo 15/09/1972.

Utilizando ```LocalDate.of(year, month, day)```

- Investigue cómo hacer para determinar si la fecha de hoy se encuentra entre las fechas 15/12/1972 y 15/12/2032. Sugerencia: vea los métodos permiten comparar LocalDates y que retornan booleans.

Combinando los métodos ```isBefore(ChronoLocalDate other)``` y ```isAfter(ChronoLocalDate other)```

- Investigue cómo hacer para calcular el número de días entre dos fechas. Lo mismo para el número de meses y de años Sugerencia: vea el método until. Tenga en cuenta que los métodos de LocalDate colaboran con otros objetos que están definidos a partir de enums, clases e interfaces de java.time; por ejemplo java.time.temporal.ChronoUnit.DAYS

Utilizando ```until(Temporal endExclusive, TemporalUnit unit)```, que puede ser invocado desde un objeto LocalDate como Until especificando un TemporalUnit como ```MONTHS```, o directamente desde TemporalUnit especificando ambos objetos LocalDate.

```
// these two lines are equivalent
   amount = start.until(end, MONTHS);
   amount = MONTHS.between(start, end);
```

### Tareas:
### a) Implemente
Implemente la clase DateLapse (Lapso de tiempo). Un objeto DateLapse representa el lapso de tiempo entre dos fechas determinadas. La primera fecha se conoce como “from” y la segunda como “to”. Una instancia de esta clase entiende los mensajes:

_public LocalDate getFrom()_: Retorna la fecha de inicio del rango.

_public LocalDate getTo()_: Retorna la fecha de fin del rango.

_public int sizeInDays()_: retorna la cantidad de días entre la fecha 'from' y la fecha 'to'.

_public boolean includesDate(LocalDate other)_: Recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario.

### b) Pruebas automatizadas
1. Diseñe los casos de prueba teniendo en cuenta los conceptos de valores de borde y particiones equivalentes vistos en la teoría.
    
- Para ```sizeInDays()```: 1 partición, donde from <= to. El valor límite es from = to
    
    Los valores a probar son:

    DAYS.between(from, to) = 0 (valor limite de la partición)
    DAYS.between(from, to) = 1 (valor vecino dentro de from <= to)

- Para ```includesDate(LocalDate other)```: 3 particiones, dependiendo si la fecha esta antes, dentro o después del periodo.

    partición antes, other < from <= to: retorna false.
    partición dentro, from <= other <= to: retorna true. Límite con antes en other = from, con después en other = to
    partición después, from <= to < other: retorna false.

    Los valores a probar son, con un lapso que cumpla DAYS.between(from, to) >= 3:
    
    DAYS.between(from, other) = -1 (valor vecino al límite de antes con dentro)
    
    DAYS.between(from, other) = 0 (valor límite de dentro con antes)
    
    DAYS.between(from, other) = 1 (valor vecino al límite de dentro con antes)
    
    DAYS.between(to, other) = -1 (valor vecino al límite de dentro con después)
    
    DAYS.between(to, other) = 0 (valor límite de dentro con después)
    
    DAYS.between(to, other) = 1 (valor vecino al límite de después con dentro)

2. Implemente utilizando JUnit los tests automatizados diseñados en el punto anterior
