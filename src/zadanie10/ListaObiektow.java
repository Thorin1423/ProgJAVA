package zadanie10;

import java.util.List;
import java.util.ArrayList;

public class ListaObiektow {
    private List<Object> elementy = new ArrayList<>(); //ukryta lista obiektow

    public void dodajObiekt(Object obiekt) {
        elementy.add(obiekt); //dodanie na koniec listy
    }

    public Object pierwszyObiekt() throws PustaListaException {
        if(elementy.isEmpty()) {
            throw new PustaListaException("Lista jest pusta!");
        }
        return elementy.get(0); //zwrocenie elementu z indeksem 0
    }

    public Object pobierzObiekt(int pozycja) throws PustaListaException, ZlyIndeksException {
        if(elementy.isEmpty()) {
            throw new PustaListaException("Lista jest pusta!");
        } else {
            if (pozycja < 0 || pozycja >= elementy.size()) {
                throw new ZlyIndeksException("Podano bledny indeks: " + pozycja);
            }
            return elementy.get(pozycja); //zwrocenie obiektu
        }
    }

    public Object usunObiekt(int pozycja) throws PustaListaException, ZlyIndeksException {
        if(elementy.isEmpty()) {
            throw new PustaListaException("Lista jest pusta!");
        }
        if (pozycja < 0 || pozycja >= elementy.size()) {
            throw new ZlyIndeksException("Podano bledny indeks: " + pozycja);
        }
        return elementy.remove(pozycja); //usuwa element i go zwraca
    }

    public int indeksObiektu(Object obiekt) throws BrakObiektuException {
        int pozycja = elementy.indexOf(obiekt); //znalezienie indeksu w liscie

        if(pozycja == -1) { //brak obiektu
            throw new BrakObiektuException("Podano bledny obiekt: " + obiekt);
        }
        return pozycja;
    }

    public Object pobierzZKolejki() throws PustaListaException { //kolejka FIFO
        if(elementy.isEmpty()) {
            throw new PustaListaException("Lista jest pusta!");
        }
        return elementy.remove(0); //usuniecie elem. z indeksem 0 i go zwrocenie
    }
}