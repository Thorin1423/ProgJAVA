public class Lotniskowiec extends Niszczyciel {
    int iloscSamolotow;

    public Lotniskowiec(int dlugosc, int szerokosc, int iloscPasaz, int wypornosc, int idOkretu, int silaRazenia, int iloscDzial, int iloscSamolotow) {
        super(dlugosc, szerokosc, iloscPasaz, wypornosc, idOkretu, silaRazenia, iloscDzial);
        this.iloscSamolotow = iloscSamolotow;
    }

    public String toString() {
        return "Lotniskowiec o ID: " + idOkretu + ", moze pomiescic " + iloscSamolotow + " samolotow";
    }
}
