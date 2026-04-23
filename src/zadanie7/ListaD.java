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

    private Element poczatek; //wskaz. 1 element
    private Element koniec; //wskaz. ostatni element
    private Element aktualny; //wskaz. obecny elem.

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
            koniec.nastepny = nowyElement; //stary koniec staje sie nastepnym
            nowyElement.poprzedni = koniec; //nowy element wskazuje na koniec jako poprzedni
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
            aktualny = poczatek; //jesli jest pierwsze to zrob od nowa
        } else {
            aktualny = aktualny.nastepny; //przesun. wskaz. na kolejny
        }
        if (aktualny != null) {
            return aktualny.wartosc;
        } else {
            return null;
        }
    }
    public E getPreviousElement() {
        if (aktualny == null) {
            aktualny = koniec; //jesli nic nie wybrano zacznij od konca
        } else {
            aktualny = aktualny.poprzedni; //przesun na poprzedni wezel
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
            Element temp = poczatek; //rozp. od 1 elem.

            while (temp.nastepny != null) { //przejscie po calej liscie
                if (temp.wartosc.compareTo(temp.nastepny.wartosc) > 0) { //lewy jest wiekszy od prawego
                    E kopia = temp.wartosc; //zamiana z uzyciem zmiennej temp
                    temp.wartosc = temp.nastepny.wartosc;
                    temp.nastepny.wartosc = kopia;
                    statusZamiany = true; //odnotowanie zmiany
                }
                temp = temp.nastepny;
            }
        } while (statusZamiany); //dopoki lista niepozostanie posortowana
    }

    public void wyswietl () {
        Element temp = poczatek;
        while (temp != null) {
            System.out.println(temp.wartosc.toString());
            temp = temp.nastepny; //przesun. na kolejny elem.
        }
    }
}