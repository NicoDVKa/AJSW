package org.threads;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Depósito de " + cantidad + " realizado. Saldo actual: " + saldo);
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        Runnable depositante1 = new Depositantante(cuenta, 200);
        Runnable depositante2 = new Depositantante(cuenta, 300);

        Thread hilo1 = new Thread(depositante1);
        Thread hilo2 = new Thread(depositante2);

        hilo1.start();
        hilo2.start();
    }
}

class Depositantante implements Runnable {
    private CuentaBancaria cuenta;
    private double cantidad;

    public Depositantante(CuentaBancaria cuenta, double cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.depositar(cantidad);
    }
}
