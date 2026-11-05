package ej24;

import org.junit.jupiter.api.Test;

public class OrdenServicioTest {

    /* calcularCosto()
    entradas    |  particiones       |  limites  |  salida
    productos   |   0, >0            |     1     |  horas * precio horas, precio productos + horas * precio horas
    tecnicos    |   0, >0            |     1     |  precio productos, precio productos + horas * precio hora
    horas       |   0, >0 <10, >= 10 | 1, 9, 10  |  precio productos, precio productos + horas * precio hora
     */

    @Test
    void calcularCosto_sinProductosConManoObra_costoManoDeObra(){}

    @Test
    void calcularCosto_conProductosYManoDeObra_sumaLosCostos(){}

    @Test
    void calcularCosto_conUnTecnico_multiplicaHorasPorPrecio(){}

    @Test
    void calcularCosto_conVariosTecnicos_sumaLosCostos(){}

    @Test
    void calcularCosto_conTecnicoSinHoras_manoDeObraEsCero(){}

    @Test
    void calcularCosto_con9Horas_devuelveCostoCompleto(){}

    @Test
    void calcularCosto_con10Horas_aplicaDescuento(){}
}
