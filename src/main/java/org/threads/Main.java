package org.threads;

public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer(10);
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);

        p.start();
        c.start();
    }
}
