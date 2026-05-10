package zadanie14;
/**
 * Reprezentuje zwykla owce bez siarki.
 */
public class Owca {
    private String imie; //imie owcy

    public Owca(String imie) { //tworzy owce o podanym imieniu
        this.imie = imie;
    }

    public String podajImieOwcy() { //zwraca imie owcy
        return imie;
    }

    public double podajIloscSiarki() { //zwraca ilosc (kg) siarki w owcy
        return 0; //dla zwyklej owcy wynosi zero
    }

    @Override
    public String toString() {
        return "Owca [" + imie + "]";
    }
}
