package org.threads;

public class Productor extends Thread{
    private Buffer buffer;
    public Productor (Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        while (true){
            int num = (int) (Math.random() * 10);
            buffer.producir(num);
            System.out.println("Producido el numero: " + num);
            try {
                sleep((int) (Math.random() * 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
