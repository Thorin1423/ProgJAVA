public class Okret {
    int dlugosc;
    int szerokosc;
    int liczbaPasaz;
    int wypornosc;
    int idOkretu;

    public Okret(int dlugosc, int szerokosc, int liczbaPasaz, int wypornosc, int idOkretu) { //konstruktor 
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.liczbaPasaz = liczbaPasaz;
        this.wypornosc = wypornosc;
        this.idOkretu = idOkretu;
    }

    public Okret(int dlugosc, int szerokosc, int idOkretu) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.idOkretu = idOkretu;
    }

    public Okret(int idOkretu) {
        this.idOkretu = idOkretu;
    }

    public int obliczPole() {
        int PoleOkretu = dlugosc * szerokosc;
        if (PoleOkretu > 0) {
            System.out.println("Pole okretu wynosi: " +  PoleOkretu);
            return PoleOkretu;
        } else {
            System.out.println("Nie mozna policzyc pola!");
            return 0;
        }
    }
}
