public class Pojazd {
    int iloscKol;
    int cena;
    int waga;
    int iloscMiejsc;

    public Pojazd(int iloscKol, int cena, int waga, int iloscMiejsc) {
        this.iloscKol = iloscKol;
        this.cena = cena;
        this.waga = waga;
        this.iloscMiejsc = iloscMiejsc;
    }
}

interface Porownywarka {
    int porownajPojazdy(Pojazd p1, Pojazd p2);
}