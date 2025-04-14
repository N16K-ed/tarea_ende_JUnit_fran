package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Cuenta cuentaPedro = new Cuenta("ES20",50);
        float saldo = cuentaPedro.getSaldo();
        assertEquals(50,saldo);
    }

    @Test
    void setSaldo() {
        cuentaPedro.setSaldo(200);
        assertEquals(200, cuentaPedro.getSaldo());
    }

    @Test
    void ingresarDinero() {
        cuentaPedro.ingresarDinero(50);
        assertEquals(150, cuentaPedro.getSaldo());
    }

    @Test
    void extraerDinero() {
        cuentaPedro.extraerDinero(50);
        assertEquals(50, cuentaPedro.getSaldo());
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

    @Test //Obviaemente con la ayuda de ChatGPT :)
    void mostrarCuenta() {
        // Redirigir la salida estándar
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaCapturada));

        // Llamar al método mostrarCuenta()
        cuentaPedro.mostrarCuenta();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Normalizar los separadores de línea. Dado que el sistema operativo puede ser diferente, es mejor normalizar la salida. A mi me da error en Windows.
        String salidaReal = salidaCapturada.toString().replace("\r\n", "\n").replace("\r", "\n");
        String salidaEsperada = "N° cuenta: ES20\nSaldo: 100.0 C\n";

        // Verificar la salida capturada
        assertEquals(salidaEsperada, salidaReal);
    }
}