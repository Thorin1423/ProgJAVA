package zadanie12;

import java.io.Serializable;

public class SerializowanaLista implements Serializable {
    public Element pierwszy; // zmienna wskazujaca na pierwszy elem z listy

    public SerializowanaLista() {
        this.pierwszy = null; //ustawienie pustej listy
    }
    
    static class Element implements Serializable {
        String tekst;
        Element nastepny;

        public Element(String tekst) {
            this.tekst = tekst;
            this.nastepny = null;
        }
    }

    public void dodaj(String tekst) {
        Element nowy = new Element(tekst);

        if (this.pierwszy == null) {
            this.pierwszy = nowy; //nowy element staje sie pierwszym
        } else {
            Element obecny = this.pierwszy;
            while (obecny.nastepny != null) {
                obecny = obecny.nastepny;
            }
            obecny.nastepny = nowy;
        }
    }

    public void wypisz() {
        if (this.pierwszy == null) {
            System.out.println("Lista jest pusta!");
            return;
        }
        Element obecny = this.pierwszy;
        System.out.print("Stan listy: ");
        while (obecny != null) {
            System.out.print(obecny.tekst + " -> ");
            obecny = obecny.nastepny;
        }
        System.out.println("null");
    }
}