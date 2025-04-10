package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void getNumero() {
    }

    @Test
    void getSaldo() {
    }

    @Test
    void setNumero() {
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
    }

    @Test
    void extraerDinero() {
    }

    @Test
    void mostrarCuenta() {
    }
}