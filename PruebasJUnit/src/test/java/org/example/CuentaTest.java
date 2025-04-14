package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    private static Cuenta cuentaPedro;

    @BeforeEach
    public void nuevaCuenta() {
        cuentaPedro = new Cuenta("ES20",100);
    }

    @AfterEach
    public void limpiarCuenta() {
        cuentaPedro = null;
    }

    @Test
    void getNumero() {
        assertEquals("ES20", cuentaPedro.getNumero());
    }

    @Test
    void getSaldo() {
        assertEquals(100, cuentaPedro.getSaldo());
    }

    @Test
    void setNumero() {
        cuentaPedro.setNumero("ES30");
        assertEquals("ES30", cuentaPedro.getNumero());
    }

    @Test
    void getSaldo1() {
        Cuenta cuentaPedro = new Cuenta("ES20",100);
        float saldo = cuentaPedro.getSaldo();
        assertEquals(100,saldo);
    }
    @Test
    void getSaldo2() {
        Cuenta cuentaPedro = new Cuenta("ES20",100);
        float saldo = cuentaPedro.getSaldo();
        assertEquals(50,saldo);
    }


    @Test
    void ingresarDinero() {
        cuentaPedro.ingresarDinero(50);
        assertEquals(150, cuentaPedro.getSaldo());
    }

    @Test
    void extraerDinero_exception() {
        try{
            Cuenta cuentaPedro = new Cuenta("ES20",100);
            cuentaPedro.extraerDinero(120);
            fail ("ERROR. Se debería haber lanzado una excepción al resultar un saldo negativo");
        }
        catch (ArithmeticException ae){ //Prueba correcta

        }
    }

    @Test
    void mostrarCuenta() {
        assertNotNull(cuentaPedro);

    }
}