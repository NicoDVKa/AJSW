package org.threads;

public class Consumidor extends Thread{
    private Buffer buffer;
    public Consumidor (Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        while(true){
            int num = buffer.consumir();
            System.out.println("Consumido el numero: " + num);
            try {
                sleep((int) (Math.random() * 20000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
