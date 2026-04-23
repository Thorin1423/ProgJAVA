package zadanie7;

public class ListaD<E extends Comparable<E>> {
    private class Element {
        E wartosc;
        Element nastepny;
        Element poprzedni;

        public Element(E wartosc) {
            this.wartosc = wartosc;
        }
    }

    private Element poczatek; //1 element
    private Element koniec; //ostatni element
    private Element aktualny; //obecny elem.

    public ListaD() {
        poczatek = null;
        koniec = null;
        aktualny = null;
    }

    public void addElement(E wartosc) {
        Element nowyElement = new Element(wartosc);
        if (poczatek == null) { //nowy element jest poczatkiem i koncem
            poczatek = nowyElement;
            koniec = nowyElement;
        } else {
            koniec.nastepny = nowyElement; //stary koniec staje sie nowy elem
            nowyElement.poprzedni = koniec; //nowy elent staje sie koncem
            koniec = nowyElement; //nowy koniec
        }
    }

    public E getFirstElement() {
        if (poczatek == null) {
            return null;
        } else {
            return poczatek.wartosc;
        }
    }

    public E getLastElement() {
        if (poczatek == null) {
            return null;
        } else {
            return koniec.wartosc;
        }
    }

    public E getNextElement() {
        if (aktualny == null) {
            aktualny = poczatek;
        } else {
            aktualny = aktualny.nastepny;
        }
        if (aktualny != null) {
            return aktualny.wartosc;
        } else {
            return null;
        }
    }
    public E getPreviousElement() {
        if (aktualny == null) {
            aktualny = koniec;
        } else {
            aktualny = aktualny.poprzedni;
        }
        if (aktualny != null) {
            return aktualny.wartosc;
        } else {
            return null;
        }
    }

    public void bubbleSort() {
        if (poczatek == null) {
            return;
        }

        boolean statusZamiany;

        do {
            statusZamiany = false;
            Element temp = poczatek;

            while (temp.nastepny != null) {
                if (temp.wartosc.compareTo(temp.nastepny.wartosc) > 0) {
                    E kopia = temp.wartosc;
                    temp.wartosc = temp.nastepny.wartosc;
                    temp.nastepny.wartosc = kopia;
                    statusZamiany = true;
                }
                temp = temp.nastepny;
            }
        } while (statusZamiany);
    }

    public void wyswietl () {
        Element temp = poczatek;
        while (temp != null) {
            System.out.println(temp.wartosc.toString());
            temp = temp.nastepny;
        }
    }
}