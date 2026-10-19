package ej12;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    private static final double DELTA = 0.001;
    private CajaDeAhorro caja;

    @BeforeEach
    void setUp(){
        caja = new CajaDeAhorro();
    }

    @Test
    void testDepositarDescuentaComision(){
        caja.depositar(100);
        assertEquals(98, caja.getSaldo(), DELTA);
    }

    @Test
    void testExtraerConSaldoSuficiente(){
        caja.depositar(100);
        assertTrue(caja.extraer(50));
        assertEquals(47, caja.getSaldo(), DELTA);
    }

    @Test
    void testExtraerConSaldoInsuficiente(){
        caja.depositar(100/0.98);
        double saldoInicial = caja.getSaldo();
        assertFalse(caja.extraer(100));
        assertEquals(saldoInicial, caja.getSaldo(),DELTA);
    }

    @Test
    void testTransferirConSaldoInsuficiente(){
        caja.depositar(100);
        Cuenta caja2 = new CajaDeAhorro();
        assertFalse(caja.transferirACuenta(98, caja2));
        assertEquals(98, caja.getSaldo(), DELTA);
        assertEquals(0, caja2.getSaldo(), DELTA);
    }

    @Test
    void testTransferirConSaldoSuficiente(){
        caja.depositar(100);
        assertEquals(98, caja.getSaldo(), DELTA);
        Cuenta caja2 = new CajaDeAhorro();
        assertTrue(caja.transferirACuenta(50, caja2));
        assertEquals(47, caja.getSaldo(), DELTA);
        assertEquals(49, caja2.getSaldo(), DELTA);
    }
}
