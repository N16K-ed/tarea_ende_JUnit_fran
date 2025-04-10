package org.example;

public class Cuenta {
    private String numero;
    private float saldo;

    public Cuenta (String numCta, float saldoCta) {
        numero = numCta;
        saldo = saldoCta;
    }

    public String getNumero(){
        return numero;
    }

    public float getSaldo(){
        return saldo;
    }

    public void setNumero(String numCta){
        numero = numCta;
    }
    public void setSaldo(float saldoCta){
        saldo = saldoCta;
    }

    public void ingresarDinero(float importe){
        saldo = saldo + importe;
    }


    public void extraerDinero(float importe){
        if ((saldo - importe) < 0)
            throw new java.lang.ArithmeticException ("Saldo negativo");
        else
            saldo = saldo - importe;
    }


    public void mostrarCuenta(){
        System.out.println ("N° cuenta: "+ getNumero());
        System.out.println ("Saldo: "+ getSaldo()+ " C");
    }
}
