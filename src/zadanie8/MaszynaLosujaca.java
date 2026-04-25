package zadanie8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

class MaszynaLosujaca<T> {

    private ArrayList<T> elementy; //pudlo
    private Random generator; //generator

    public MaszynaLosujaca() {
        this.elementy = new ArrayList<>(); //puste pudlo
        this.generator = new Random();
    }

    public void dodaj(T element) {
        elementy.add(element); //dodanie do pudla
    }

    public T losujElement() { //metoda do losowania
        if (elementy.isEmpty()) {
            return null;
        } else {
            int wylosowanyIndeks = generator.nextInt(elementy.size()); //losowanie numeru
            return elementy.remove(wylosowanyIndeks); //wyciagniecie
        }
    }

    public ArrayList<T> losujListe() {
        ArrayList<T> potasowanaLista = new ArrayList<>(elementy); //nowa lista i kopiowanie do niej zawart. maszyny
        Collections.shuffle(potasowanaLista); //tasowanie
        return potasowanaLista;
    }
}
