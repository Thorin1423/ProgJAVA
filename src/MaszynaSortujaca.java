public class MaszynaSortujaca {
    Pojazd[] pojazdy;
    Porownywarka porownywarka;
    int licznik = 0;

    public MaszynaSortujaca(Porownywarka p, int maksymalnaIloscPojazdow) {
        this.porownywarka = p;
        this.pojazdy = new Pojazd[maksymalnaIloscPojazdow];
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
        for (int i = 0; i < licznik - 1; i++) {
            for (int j = 0; j < licznik - 1 - i; j++) {

                Pojazd p1 = pojazdy[j];
                Pojazd p2 = pojazdy[j + 1];

                if (porownywarka.porownajPojazdy(p1, p2) > 0) {
                    Pojazd temp = pojazdy[j];
                    pojazdy[j] = pojazdy[j + 1];
                    pojazdy[j + 1] = temp;
                }
            }
        }
    }
}