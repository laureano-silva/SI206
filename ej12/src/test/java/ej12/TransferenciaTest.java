package ej12;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TransferenciaTest {
    private static final double DELTA = 0.001;
    private CajaDeAhorro caja1;
    private CuentaCorriente cuenta1;

    @BeforeEach
    void SetUp(){
        caja1 = new CajaDeAhorro();
        cuenta1 = new CuentaCorriente();
    }

    @Test
    void testTransferenciaCajaACuenta(){
        caja1.depositar(100); // saldo: 98
        assertEquals(98, caja1.getSaldo());
        assertTrue(caja1.transferirACuenta(50, cuenta1)); // saldo: 98 - 50 - 1 = 47
        assertEquals(47, caja1.getSaldo(), DELTA);
        assertEquals(50, cuenta1.getSaldo(), DELTA);
    }

    @Test
    void testTransferenciaCuentaACaja(){
        cuenta1.depositar(100);
        assertEquals(100, cuenta1.getSaldo());
        assertTrue(cuenta1.transferirACuenta(100, caja1)); // saldo: 98 - 50 - 1 = 47
        assertEquals(98, caja1.getSaldo(), DELTA);
        assertEquals(0, cuenta1.getSaldo(), DELTA);
    }
}
