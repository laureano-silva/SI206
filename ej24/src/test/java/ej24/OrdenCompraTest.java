package ej24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenCompraTest {
    private OrdenCompra ordenVacia;
    private OrdenCompra ordenConEnvio;
    private OrdenCompra orden1;
    private OrdenCompra orden4;

    @BeforeEach
    void setUp(){
        ordenVacia = new OrdenCompra(LocalDate.of(2026, 11, 1), "calle 123", 500);
        ordenConEnvio = new OrdenCompra(LocalDate.of(2026, 11, 1), "calle 123", 750);

        orden1 = new OrdenCompra(LocalDate.of(2026, 11, 5), "calle 123", 0);
        orden1.agregarProducto(new Producto("producto 1", "material1", 100, false));

        orden4 = new OrdenCompra(LocalDate.of(2026, 11, 6), "calle 123", 0);
        orden4.agregarProducto(new Producto("producto 1", "material1", 100, true));
        orden4.agregarProducto(new Producto("producto 2", "material2", 200, false));
        orden4.agregarProducto(new Producto("producto 3", "material3", 300, true));
        orden4.agregarProducto(new Producto("producto 4", "material4", 400, false));
    }

    /* calcularCosto()
    entradas         |  particiones  |  limites  | salida
    precioEnvío      |    0, >0      |    1      |  precioProducto, precioProducto + precioEnvío
    productos        |    0, >0      |    1      |  cero, suma de precioProducto * precioEnvio
    cantProductos    |  <5, >=5      |   4, 5    |  costo total, costo total*0.9
     */

    @Test
    void calcularCosto_precioEnvioCero_devuelvePrecioProducto(){
        assertEquals(100, orden1.calcularCosto());
    }

    @Test
    void calcularCosto_conPrecioEnvio_sumaAlPrecioDelProducto(){
        ordenConEnvio.agregarProducto(new Producto("producto", "material", 2499.99, false));
        assertEquals(3249.99, ordenConEnvio.calcularCosto());
    }

    @Test
    void calcularCosto_sinProductos_esCero(){ // con precio de envio para verificar que no lo sume
        assertEquals(0, ordenVacia.calcularCosto());
    }

    @Test
    void calcularCosto_conVariosProductos_losSuma(){ // cubre borde donde no se aplica el descuento
        assertEquals(100 + 200 + 300 + 400, orden4.calcularCosto());
    }

    @Test
    void calcularCosto_con5Productos_aplicaDescuento(){
        orden4.agregarProducto(new Producto("producto 5", "material 5", 500, false));
        double costoConDescuento = 0.9*(100 + 200 + 300 + 400 + 500);
        assertEquals(costoConDescuento, orden4.calcularCosto(), 0.0001);
    }

}
