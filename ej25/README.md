# Ejercicio 25. Bag 

## Primera parte
Un Map en Java es una colección que asocia objetos que actúan cómo claves (keys), a otros objetos que actúan cómo valores (values). En otros lenguajes también se llaman Dictionary (Diccionario). Cada clave está vinculada a un único valor; no pueden existir claves duplicadas en un mapa, aunque sí podrían haber valores repetidos. A los pares clave-valor se los denomina entradas (entries).
Para definir un Map, es necesario indicar el tipo que tendrán sus claves y valores: por ejemplo, una variable de tipo Map<String, Integer> define un mapa en donde sus claves son de tipo String, y sus valores de tipo Integer. Observe que Map<K, V> es una interfaz.

### Tareas:

#### a) Lea la documentación de Map en Java y responda:

#### 1. ¿Qué implementaciones provee Java para utilizar un Map? ¿Cuáles de ellas son destinadas a uso general?

Java organiza las implementaciones de Map en tres grupos:

De uso general

- HashMap: tabla de hash. No garantiza ningún orden. Es la más rápida para put/get (O(1) promedio) y es la opción por defecto.
- TreeMap: árbol rojo-negro. Mantiene las claves ordenadas, por orden natural o por un Comparator. Implementa SortedMap/NavigableMap. Sus operaciones son O(log n).
- LinkedHashMap: tabla de hash más una lista enlazada. Mantiene el orden de inserción, o el de acceso si se configura así. Es casi tan rápida como HashMap.

De propósito específico

- EnumMap: para claves que son de un enum. Internamente usa un arreglo, así que es muy eficiente.
- WeakHashMap: guarda referencias débiles a las claves. Una entrada se elimina cuando el garbage collector recolecta su clave.
- IdentityHashMap: compara las claves con == en lugar de equals().

Concurrentes (java.util.concurrent)

- ConcurrentHashMap
- ConcurrentSkipListMap (ordenado)

#### 2. Investigue cómo consultar sí un mapa contiene una determinada clave (key). Explique qué métodos deben implementar las claves para que esto funcione correctamente

Con el método `boolean containsKey(Object key)`, que devuelve true si y solo si existe una clave tal que (key==null ? k==null : key.equals(k))

Para esto, las clases utilizadas como clave tienen que implementar:
- hashCode(): returns an integer hash value used by the map to place and locate the key inside internal buckets.
- equals(): compares two keys for equality when a hash collision occurs or when verifying reference/logical equivalence.

#### 3. ¿Con qué método se puede recuperar el objeto asociado a una clave? ¿Qué pasa sí la clave no existe en el mapa?

Con `get(Object key)`, que devuelve `null` en caso de que la clave no exista en el mapa.

#### 4. Investigue cómo agregar claves y valores a un mapa. ¿Qué pasa sí la clave ya se encontraba en el mapa? ¿Permite agregar claves y/o valores nulos? 

Con `put(K key, V value)` se agrega un par clave-valor o, si la clave ya existe, se reemplaza su valor por el pasado por parámetro. Devuelve el valor anterior si la clave ya existía, o null (también devuelve null si la clave estaba mapeada con null).

#### 5. Determine cómo se pueden eliminar claves y valores de un mapa. ¿Es necesario controlar la presencia de alguno de ellos?

Para eliminar valores por clave:

`remove(key)` elimina la entrada y devuelve el valor que tenía, o null si la clave no estaba.

`remove(key, value)` elimina solo si la clave está asociada a ese valor exacto. Devuelve boolean.

Para eliminar valores por valor Map no tiene un método específico, se hace a través de las vistas:

`map.values().remove(v)` elimina la primera entrada con ese valor.

`map.values().removeIf(v -> v.equals(x))` elimina todas las que tengan ese valor.

`map.entrySet().removeIf(e -> ...)` filtra por clave, por valor o por ambos.

Se puede vaciar el mapa completo con `clear()`.

No es necesario controlar que la clave o el valor estén presentes. Si la clave no existe, remove no hace nada y no lanza excepción. Solo hay que tener en cuenta que en un mapa que admite valores null, como HashMap, que remove devuelva null no te dice si la clave no estaba o si estaba asociada a null. Si esa diferencia importa, hay que usar containsKey antes.

#### 6. Investigue cómo reemplazar un valor en un mapa

Hay varias opciones:


`put(key, nuevo)` sobrescribe el valor si la clave existe y devuelve el anterior. Si la clave no existe, la inserta.

`replace(key, nuevo)` reemplaza solo si la clave ya existe. Si no existe, no inserta nada y devuelve null.

`replace(key, viejo, nuevo)` reemplaza solo si el valor actual es viejo. Devuelve boolean.

`replaceAll((k, v) -> ...)` aplica una función a todos los valores.
`computeIfPresent` y `merge` sirven para calcular el nuevo valor a partir del actual, por ejemplo para incrementar un contador.

Mientras se itera `entrySet()`, `entry.setValue(nuevo)` modifica el valor directamente en el mapa.


#### 7. Teniendo en cuenta los métodos keySet(), values() y entrySet(), explique de qué formas se puede iterar un mapa ¿Es posible utilizar streams?

```java
// Solo claves (si necesitás el valor, hace un get extra por cada una)
for (String k : map.keySet()) { map.get(k); }

// Solo valores (no tenés acceso a la clave)
for (Integer v : map.values()) { ... }

// Clave y valor juntos (lo más eficiente si necesitás ambos)
for (Map.Entry<String, Integer> e : map.entrySet()) {
    e.getKey(); e.getValue();
}

// forEach con lambda (Java 8+)
map.forEach((k, v) -> ...);
```

`Map` no extiende `Collection`, así que no existe `map.stream()`. Lo que se hace es usar el stream de alguna de las vistas, que sí son colecciones:

```java 
map.entrySet().stream()
   .filter(e -> e.getValue() > 10)
   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
```

#### b) Para practicar los mensajes investigados anteriormente, escriba un test de unidad que contenga lo siguiente:

1. Cree un map un Map<String, Integer>, y agregue las tuplas (“Lionel Messi”, 111), (“Gabriel Batistuta”, 56), (“Kun Agüero”, 42)

2. Elimine la entrada con clave “Kun Agüero” 

3. Messi hizo 112 goles a día de la fecha; actualice la cantidad de goles 

4. Intente repetir la clave “Gabriel Batistuta” y verifique que no es posible.

5. Obtenga la cantidad total de goles 

#### c) Como se mencionó, cualquier objeto puede actuar como clave. Es decir, pueden ser instancias de clases definidas por el programador. Modele e implemente la clase Jugador con apellido y nombre. Escriba otro test de unidad similar al de la tarea 2, pero utilizando Map<ej25.Jugador, Integer>

## Segunda parte

Un **Bag** (bolsa) es una colección que permite almacenar elementos sin ningún orden específico y admite elementos repetidos. Este objeto requiere un buen tiempo de respuesta para conocer la **cardinalidad** de sus elementos, y por esa razón almacena la cardinalidad de cada elemento (cantidad de veces que fue agregado en la bolsa). Por ejemplo, sí agregamos 3 veces un objeto en la bolsa, y luego eliminamos 1 referencia, la cardinalidad de ese objeto en la bolsa es 2.

El protocolo de la interface `Bag<T>` es:

```java
public interface Bag<T> extends Collection<T> {
    /**
     * Agrega un elemento al Bag, incrementando en 1 su cardinalidad.
     */
    @Override
    boolean add(T element);

    /**
     * Devuelve la cardinalidad del elemento. Sí el elemento no está en el Bag,            
     * devuelve 0.
     */
    int occurrencesOf(T element);

    /**
     * Elimina una referencia del elemento del Bag. Sí el elemento no está en 
     * el Bag, no hace nada.
     */
    void removeOccurrence(T element);

    /**
     * Elimina el elemento del Bag. Sí el elemento no está en el Bag, no hace
     * nada
     */
    void removeAll(T element);

    /**
     * Devuelve el número total de elementos en el Bag, es decir, la suma de
     * todas las cardinalidades de todos sus elementos.
     */
    @Override
    int size();
}
```


Observe que la interfaz `Bag<T>` extiende `Collection<T>`. 

### Tareas:

1. Liste los métodos que debe contener una clase que implementa la interface Bag<T>.

Todos los del protocolo de `Bag<T>` y además los de `Collection<T>`.

Métodos de `Bag<T>`:


- `boolean add(T element)`: redefine el de Collection. Incrementa la cardinalidad en 1.
- `int occurrencesOf(T element)`
- `void removeOccurrence(T element)`
- `void removeAll(T element)`
- `int size()`: redefine el de Collection. Devuelve la suma de todas las cardinalidades.

Métodos abstractos heredados de Collection<T>, que también incluye iterator() de Iterable:

- `isEmpty()`
- `contains(Object o)`
- `iterator()`
- `toArray()`
- `toArray(T[] a)`
- `remove(Object o)`
- `containsAll(Collection<?> c)`
- `addAll(Collection<? extends T> c)`
- `removeAll(Collection<?> c)`
- `retainAll(Collection<?> c)`
- `clear()`
- `equals(Object o)`
- `hashCode()`

2. Explique cómo implementaría un `Bag<T>` usando composición con un `Map<K, V>`. ¿De qué tipo tendrían que ser las claves y valores del Map?

Con un Map<T, Integer>.

3. Implemente la interfaz `Bag<T>`, utilizando `AbstractCollection<T>` como superclase, y componga con un `Map<T, V>`. Para simplificar la implementación utilice la clase BagImpl que se encuentra en este link. 

4. Discuta con un ayudante:
   
   a) ¿Cuáles son los beneficios de utilizar AbstractCollection como superclase para implementar el Bag?
    
   b) ¿Qué ventajas tiene componer con un Map para implementar el Bag?
    
   c) En lugar de componer con un Map, ¿es posible extenderlo para poder implementar el Bag? ¿Qué diferencias tendría esa solución con respecto a la planteada en este ejercicio?
    
   d) ¿Para qué cree que podría ser útil un objeto Bag?
