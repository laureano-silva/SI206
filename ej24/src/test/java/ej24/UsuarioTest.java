package ej24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    private Usuario juanMartinez;
    private OrdenCompra ordenCompra;
    private OrdenServicio ordenServicio;
    private Tecnico luciaIraola;
    private Producto panelSolar;
    private Producto compostera;
    private Producto calefonSolar;

    @BeforeEach
    void setUp(){
        juanMartinez = new Usuario("Juan Martinez", "Larrea 5800");

        ordenCompra = new OrdenCompra(LocalDate.of(2026, 11, 5), "Larrea 5800", 0);
        panelSolar = new Producto("Panel solar", "Reciclables", 35000, false);
        compostera = new Producto("Compostera", "", 8000, true);
        ordenCompra.agregarProducto(panelSolar);
        ordenCompra.agregarProducto(compostera);

        ordenServicio = new OrdenServicio(LocalDate.of(2026, 11, 5), "Larrea 5800", "Instalacion calefon solar", 5);
        luciaIraola = new Tecnico("Lucia Iraola", "Instalaciones solares", 4500);
        calefonSolar = new Producto("Calefon solar", "Reciclables", 50000, false);
        ordenServicio.agregarTecnico(luciaIraola);
        ordenServicio.agregarProducto(calefonSolar);

        juanMartinez.agregarOrden(ordenCompra);
        juanMartinez.agregarOrden(ordenServicio);
    }

    @Test
    void verificarTotalOrdenesTest(){
        // hecho asi nomas para validar
        assertEquals(72500,ordenServicio.calcularCosto());
        assertEquals(43000,ordenCompra.calcularCosto());
        List<Orden> ordenes = juanMartinez.getOrdenes();
        assertEquals(72500 + 43000, ordenes.stream()
                .mapToDouble(Orden::calcularCosto)
                .sum());
    }
}
