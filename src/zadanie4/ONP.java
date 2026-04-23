public class ONP {
    String wyrazenie;

    public ONP(String wyrazenie) { //konstruktor klasy aby miec dostep do niego
        this.wyrazenie = wyrazenie;
    }

    public int wyznaczWartosc() {
        String[] podzielone = this.wyrazenie.split(" "); //podzielenie tekstu na pojedyncze znaki i utw. tablicy

        Stos s = new Stos(); //tworzenie nowego stosu

        for (String element: podzielone){ //po kolei po kazdym elem. tablicy podzielone
            if (element.equals("-")) { //sprawdzenie znaku
                int pobranaLiczba = (int) s.pobierz();  //zdjecie liczby z gory stosu z rzutowaniem na int
                s.wstaw(-pobranaLiczba); //odlozenie na stos z zmien. znakiem
                } else if (element.equals("+")) {
                    int pobranaLiczba = (int) s.pobierz();
                    int pobranaDrugaLiczba = (int) s.pobierz();
                    int suma = pobranaLiczba+pobranaDrugaLiczba;
                    s.wstaw(suma);
                } else if (element.equals("*")) {
                    int pobranaLiczba = (int) s.pobierz();
                    int pobranaDrugaLiczba = (int) s.pobierz();
                    int iloczyn = pobranaLiczba*pobranaDrugaLiczba;
                    s.wstaw(iloczyn);
                } else {
                    int liczba = Integer.parseInt(element); //zamiana z string na int
                    s.wstaw(liczba);
            }
        }
        return (int) s.pobierz();
    }

    public static void main(String[] args) {
        ONP kalkulator = new ONP("2 3 + 5 *"); // inny przyklad 12 2 3 * + powinno wyjsc 18
        System.out.println("Wynik: " + kalkulator.wyznaczWartosc());
    }
}