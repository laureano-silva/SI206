## Ejercicio 7: Balanza mejorada
Realizando el ejercicio de los presupuestos, aprendimos que un objeto puede tener una colección de otros objetos. Con esto en mente, ahora queremos mejorar la balanza implementada  en el ejercicio 2.

### Tarea 1
Mejorar la balanza para que recuerde los productos ingresados (los mantenga en una colección). Analice de qué forma puede realizarse este nuevo requerimiento e implemente el mensaje
public List<Producto> getProductos()
que retorna todos los productos ingresados a la balanza (en la compra actual, es decir, desde la última vez que se la puso a cero).

¿Qué cambio produce este nuevo requerimiento en la implementación del mensaje ponerEnCero() ?

- Hace falta vaciar la lista de productos.

¿Es necesario, ahora, almacenar los totales en la balanza? ¿Se pueden obtener estos valores de otra forma?
- No, se pueden calcular los totales recorriendo la lista.


### Tarea 2
Con esta nueva funcionalidad, podemos enriquecer al Ticket, haciendo que él también conozca a los productos (a futuro podríamos imprimir el detalle). Ticket también debería entender el mensaje  public List<Producto> getProductos().

¿Qué cambios cree necesarios en Ticket para que pueda conocer a los productos?
¿Estos cambios modifican las responsabilidades ya asignadas de realizar cálculo del precio total?. ¿El ticket adquiere nuevas responsabilidades que antes no tenía?

- Las responsabilidades se mantienen sin cambios.

### Tarea 3
Después de hacer estos cambios, ¿siguen pasando los tests? ¿Está bien que sea así?
- Siguen pasando porque los mensajes que Balanza, Producto y Ticket comprenden no cambiaron.