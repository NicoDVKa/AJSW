package org.collections;

import java.util.*;
public class Colecciones extends Thread{

    private Contador contador;
    private final int aEjecutar;
    private final String nombre;

    public  Colecciones(int aEjecutar){
        this.aEjecutar = aEjecutar;
        this.nombre = "x";
    }

    public Colecciones(String nombre, Contador contador){
        this.aEjecutar = 4;
        this.nombre = nombre;
        this.contador = contador;
    }

    public void run(){
        if(aEjecutar == 1){
            ejecutarLista();
        }
        else if(aEjecutar == 2){
            ejecutarSet();
        }
        else if(aEjecutar == 3){
            ejecutarMap();
        }else {
            contador.contar(this.nombre);
        }
    }


    private void ejecutarLista(){
        List<Integer> numeros = Arrays.asList(6,1,2,3,4,5,1);
        numeros.sort(null);
        System.out.println(numeros);
        numeros.set(5,10);
        System.out.println(numeros.get(0));
        System.out.println(numeros);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Integer> numeros4 = new LinkedList<>(numeros);
        System.out.println(numeros4);
        numeros4.add(11);
        System.out.println(numeros4.size());

        System.out.println(numeros4);

        List<Integer> numeros3 = new Vector<>(numeros4);
        Iterator<Integer> iterador = numeros3.iterator();
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }

    }

    private void ejecutarSet(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<String> numeros1 = new TreeSet<>();
        numeros1.add("Caro");numeros1.add("Nico");numeros1.add("Mali");numeros1.add("Mali");
        System.out.println(numeros1);

        Set<String> numeros2 = new HashSet<>();
        numeros2.add("Caro");numeros2.add("Nico");numeros2.add("Mali");numeros2.add("Mali");
        System.out.println(numeros2);

        Set<String> numeros3 = new LinkedHashSet<>();
        numeros3.add("Caro");numeros3.add("Nico");numeros3.add("Mali");numeros3.add("Mali");
        Iterator<String> iterador = numeros3.iterator();

        while (iterador.hasNext()){
            System.out.println(iterador.next() + " ");
        }

    }

    private void ejecutarMap(){
        Map<String, Integer> numeros5 = new HashMap<>();
        numeros5.put("Caro",1);
        numeros5.put("Caro1",3);
        numeros5.put("Caro11",4);
        numeros5.put("Caro11",5);
        numeros5.put("Caro1",6);

        Iterator<Integer> iterador1 = numeros5.values().iterator();
        System.out.println(numeros5);
        while(iterador1.hasNext()){
            System.out.println(iterador1.next() + " ");
        }

        System.out.println(numeros5.get("Caro2"));


        Map<String, Integer> numeros6 = new TreeMap<>(numeros5);
        numeros6.put("A",10000);
        numeros6.put("a",1);
        System.out.println(numeros6);

    }



}
