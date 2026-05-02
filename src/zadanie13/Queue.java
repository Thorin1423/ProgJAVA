package zadanie13;

import java.nio.file.FileSystemNotFoundException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Queue {
    LinkedList<Integer> kolejka = new LinkedList<>(); //nowa kolejka
    int maksymPojemnosc; //maks. wielkosc bufora

    public Queue(int maksymPojemnosc) {
        this.maksymPojemnosc = maksymPojemnosc;
    }

    synchronized public void put(int element) {
        while(kolejka.size() == maksymPojemnosc){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        kolejka.add(element); //dodanie na koniec kolejki
        System.out.println("Dodanie do kolejki: " + element);
        notify(); //poczat. konsumenta
    }

    synchronized public int get() {
        while(kolejka.isEmpty()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int temp = kolejka.removeFirst();
        System.out.println("Pobrano z kolejki: " + temp);
        notify(); //poczat. producenta
        return temp;
    }

}