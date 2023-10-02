package org.threads;

public class ContadorConHilos {
    public static void main(String[] args) {
        // Crear dos objetos Runnable para contar hasta 10
        Runnable contador1 = new Contador("Hilo 1");
        Runnable contador2 = new Contador("Hilo 2");

        // Crear dos hilos y comenzar su ejecución
        Thread hilo1 = new Thread(contador1);
        Thread hilo2 = new Thread(contador2);

        hilo1.start();
        hilo2.start();
    }
}

class Contador implements Runnable {
    private final String nombre;

    public Contador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + ": " + i);

            try {
                // Simular un pequeño retraso
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
