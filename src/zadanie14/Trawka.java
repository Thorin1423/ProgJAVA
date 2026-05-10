package zadanie14;
/**
 * Reprezentuje trawke.Jest to pozywienie dla owiec.
 */
public class Trawka {
    private String gatunek; //rodzaj trawki

    public Trawka(String rodzaj) { //tworzy trawe o podanym gatunku
        this.gatunek = rodzaj;
    }

    public String podajGatunek() { //zwraca gatunek trawy
        return gatunek;
    }
}
