package ej17;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.SettingDefinition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {
    private ClienteDeCorreo cliente;
    private Email email;


    @BeforeEach
    void setUp(){
        cliente = new ClienteDeCorreo();
        email = new Email("asunto","prueba cuerpo");
    }

    @Test
    void recibir_conInboxVacio_quedaEnElCliente(){
        cliente.recibir(email);
        assertSame(email, cliente.buscar("prueba")); // assertSame para validar que sea el mismo objeto
    }

    @Test
    void recibir_conInboxConMails_quedaEnElCliente(){
        cliente.recibir(email);
        Email email2 = new Email("email 2", "lorem ipsum");
        cliente.recibir(email2);
        assertSame(email2, cliente.buscar("lorem")); // assertSame para validar que sea el mismo objeto
    }
}
