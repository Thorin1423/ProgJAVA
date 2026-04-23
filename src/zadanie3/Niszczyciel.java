public class Niszczyciel extends Okret {
    int silaRazenia;
    int iloscDzial;

    public Niszczyciel(int dlugosc, int szerokosc, int iloscPasaz, int wypornosc, int idOkretu, int silaRazenia, int iloscDzial){
        super(dlugosc, szerokosc, iloscPasaz, wypornosc, idOkretu);
        this.silaRazenia = silaRazenia;
        this.iloscDzial = iloscDzial;
    }

    public String toString(){
        return "Niszczyciel o ID: " + idOkretu + ", ma liczbe dzial: " + iloscDzial + ", przy czym sila razenia wynosi: " +  silaRazenia;
    }
}
