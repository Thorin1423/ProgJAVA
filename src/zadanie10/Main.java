package zadanie10;

public class Main {
    public static void main(String[] args) {
        System.out.println("--Test listy obiektow--");

        ListaObiektow lista = new ListaObiektow();

        System.out.println("\n[1] Proba pobrania z pustej listy:"); //test bledu dla PustaListaException
        try {
            lista.pierwszyObiekt();
        } catch (PustaListaException e) {
            System.out.println("Sukces! - Złapano wyjątek: " + e.getMessage());
        }

        System.out.println("\n---Dodanie 3 elem. do listy---"); //dodanie danych przykl.
        lista.dodajObiekt("Myszka");
        lista.dodajObiekt("Butelka");
        lista.dodajObiekt("Dlugopis");
        System.out.println("Dodano: Myszka, Butelka oraz Dlugopis.");

        System.out.println("\n[2] Pobieranie elementu o indeksie 1:"); //test dla poprawnego dzialania
        try {
            Object pobrany = lista.pobierzObiekt(1);
            System.out.println("Pobrano obiekt: " + pobrany + " (Oczekiwano: Butelka)");
        } catch (Exception e) {
            System.out.println("Blad!: " + e.getMessage());
        }

        System.out.println("\n[3] Proba pobrania elementu z indeksem niemozliwym 1000:"); //test dla bledu ZlyIndeksException
        try {
            lista.pobierzObiekt(1000);
        } catch (ZlyIndeksException | PustaListaException e) {
            System.out.println("Sukces! - Zlapano wyjatek: " + e.getMessage());
        }

        System.out.println("\n[4] Szukanie obiektu,ktorego nie ma na liscie:"); //test dla bledu BrakobiektuException
        try {
            lista.indeksObiektu("Bidon");
        } catch (BrakObiektuException e) {
            System.out.println("Sukces! - Zlapano wyjatek: " + e.getMessage());
        }

        System.out.println("\n[5] Test kolejki (FIFO):");
        try {
            Object zKolejki = lista.pobierzZKolejki(); //first in, first out
            System.out.println("Z kolejki: " + zKolejki + " (Oczekiwano: Myszka)");

            System.out.println("Nowy pierwszy element to: " + lista.pierwszyObiekt() + " (Oczekiwano: Butelka)");
        } catch (Exception e) {
            System.out.println("BŁĄD: " + e.getMessage());
        }
    }
}