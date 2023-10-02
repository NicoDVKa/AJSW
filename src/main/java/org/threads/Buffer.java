package org.threads;

public class Buffer {
    private int[] nums;
    private int siguiente;
    private boolean estaLlena;
    private boolean estaVacia;
    public Buffer(int size){
        this.nums = new int[size];
        this.estaLlena = false;
        this.estaVacia = true;
        this.siguiente = 0;
    }
    public synchronized int consumir(){
        while(this.estaVacia){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.estaLlena = false;
        this.siguiente--;
        if(this.siguiente == 0){
            this.estaVacia = true;
        }
        int producido = this.nums[this.siguiente];
        notifyAll();
        return  this.nums[this.siguiente];
    }
    public synchronized void producir(int num){
        while(this.estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        nums[this.siguiente] = num;
        this.siguiente++;
        this.estaVacia = false;
        if(this.siguiente == this.nums.length){
            this.estaLlena = true;
        }
        notifyAll();
    }
}
