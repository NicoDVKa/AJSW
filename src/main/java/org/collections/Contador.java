package org.collections;

public class Contador {

    public synchronized void contar(String nombre){
        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("El hilo " + nombre + " -> " + i);
        }
    }
}
