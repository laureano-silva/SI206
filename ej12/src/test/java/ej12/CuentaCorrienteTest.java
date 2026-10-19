package ej12;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {
    private static final double DELTA = 0.001;
    private CuentaCorriente cuenta1;


    @BeforeEach
    void SetUp(){
        cuenta1 = new CuentaCorriente();
    }

    @Test
    void testDepositar(){
        cuenta1.depositar(100);
        assertEquals(100, cuenta1.getSaldo(), DELTA);
    }

    @Test
    void testExtraerConSaldoSuficiente(){
        cuenta1.setDescubierto(500);
        assertTrue(cuenta1.extraer(300));
        assertEquals(-300, cuenta1.getSaldo(), DELTA);
    }

    @Test
    void testExtraerConSaldoInsuficiente(){
        cuenta1.setDescubierto(500);
        assertFalse(cuenta1.extraer(600));
        assertEquals(0, cuenta1.getSaldo(), DELTA);
    }

    @Test
    void testTransferirConSaldoInsuficiente(){
        cuenta1.setDescubierto(200);
        CuentaCorriente cuenta2 = new CuentaCorriente();
        assertFalse(cuenta1.transferirACuenta(300, cuenta2));
        assertEquals(0, cuenta1.getSaldo(), DELTA);
        assertEquals(0, cuenta2.getSaldo(), DELTA);
    }

    @Test
    void testTransferirConSaldoSuficiente(){
        cuenta1.setDescubierto(200);
        CuentaCorriente cuenta2 = new CuentaCorriente();
        assertTrue(cuenta1.transferirACuenta(100, cuenta2));
        assertEquals(-100, cuenta1.getSaldo(), DELTA);
        assertEquals(100, cuenta2.getSaldo(), DELTA);
    }
}
