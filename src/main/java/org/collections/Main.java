package org.collections;


public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Contador contador1 = new Contador();
        Colecciones hola = new Colecciones(1);
        Colecciones hola1 = new Colecciones("T1",contador);
        Colecciones hola2 = new Colecciones("T2",contador);
        Colecciones hola3 = new Colecciones("T3",contador1);

        hola.start();
        hola1.start();
        hola2.start();
        hola3.start();

        try {
            hola1.join();
            hola2.join();
            hola3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Termino el programa!!!");

    }

}

