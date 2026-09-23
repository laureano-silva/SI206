## Ejercicio 9: Genealogía salvaje
En una reserva de vida salvaje (como la estación de cría ECAS, en el camino Centenario), los cuidadores quieren llevar registro detallado de los animales que cuidan y sus familias. Para ello nos han pedido ayuda. Debemos:
### Tareas:
#### a) Complete el diseño e implemente

Modelar una solución en objetos e implementar la clase Mamífero (como subclase de Object). El siguiente diagrama de clases (incompleto) nos da una idea de los mensajes que un mamífero entiende.
Proponga una solución para el método tieneComoAncestroA(...) y deje la implementación para el final y discuta su solución con el ayudante.

```mermaid
classDiagram
    class Mamifero {
        -? : ?
        +getIdentificador() String
        +setIdentificador(id: String)
        +getEspecie() String
        +setEspecie(especie: String)
        +getFechaNacimiento() Date
        +setFechaNacimiento(fecha: Date)
        +getPadre() Mamifero
        +setPadre(padre: Mamifero)
        +getMadre() Mamifero
        +setMadre(madre: Mamifero)
        +getAbueloMaterno() Mamifero
        +getAbuelaMaterna() Mamifero
        +getAbueloPaterno() Mamifero
        +getAbuelaPaterna() Mamifero
        +tieneComoAncestroA(unMamifero: Mamifero) Boolean
    }
```

Complete el diagrama de clases para reflejar los atributos y relaciones requeridas en su solución.

```mermaid
classDiagram
    class Mamifero {
        -identificador : String
        -especie : String
        -fechaNacimiento : Date
        -padre : Mamifero
        -madre : Mamifero
        +getIdentificador() String
        +setIdentificador(id: String)
        +getEspecie() String
        +setEspecie(especie: String)
        +getFechaNacimiento() Date
        +setFechaNacimiento(fecha: Date)
        +getPadre() Mamifero
        +setPadre(padre: Mamifero)
        +getMadre() Mamifero
        +setMadre(madre: Mamifero)
        +getAbueloMaterno() Mamifero
        +getAbuelaMaterna() Mamifero
        +getAbueloPaterno() Mamifero
        +getAbuelaPaterna() Mamifero
        +tienePadre() Boolean
        +tieneMadre() Boolean
        +tieneComoAncestroA(unMamifero: Mamifero) Boolean
    }
```

#### b) Pruebas automatizadas
Siguiendo los ejemplos de ejercicios anteriores, ejecute las pruebas automatizadas provistas. En este caso, se trata de una clase, MamiferoTest, que debe agregar dentro del paquete tests. En esta clase se trabaja con la familia mostrada en la siguiente figura.

![familia](familia.jpg)

En el diagrama se puede apreciar el nombre/identificador de cada uno de ellos (por ejemplo Nala, Mufasa, Alexa, etc).
Haga las modificaciones necesarias para que el proyecto no tenga errores.  Si algún test no pasa, consulte al ayudante. 
