public class MaszynaSortujaca {
    Pojazd[] pojazdy; //tablica dla pojazdow
    Porownywarka porownywarka; //obiekt klasy Porownywarka
    int licznik = 0;

    public MaszynaSortujaca(Porownywarka p, int maksymalnaIloscPojazdow) { //konstruktor
        this.porownywarka = p;
        this.pojazdy = new Pojazd[maksymalnaIloscPojazdow]; //stworzenie pustej tablicy o danym rozm.
    }

    public void dodajPojazd(Pojazd p) {
        pojazdy[licznik] = p;
        licznik++;
    }

    public void wypisz() {
        System.out.println("Lista pojazdow:");
        for (int i = 0; i < licznik; i++) {
            Pojazd aktualny = pojazdy[i];
            System.out.println("Pojazd " + i + ": " +
                    "Koła = " + aktualny.iloscKol +
                    ", Cena = " + aktualny.cena +
                    ", Waga = " + aktualny.waga +
                    ", Miejsca = " + aktualny.iloscMiejsc);
        }
        System.out.println("");
    }

    public void sortuj() {
        for (int i = 0; i < licznik - 1; i++) { // ilosc przejsc
            for (int j = 0; j < licznik - 1 - i; j++) { //porownanie sasiadow

                Pojazd p1 = pojazdy[j];
                Pojazd p2 = pojazdy[j + 1];

                if (porownywarka.porownajPojazdy(p1, p2) > 0) { //jesli wynik>0 to p1 jest za p2
                    Pojazd temp = pojazdy[j]; //zamiana miejscami
                    pojazdy[j] = pojazdy[j + 1];
                    pojazdy[j + 1] = temp;
                }
            }
        }
    }
}