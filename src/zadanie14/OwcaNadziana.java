package zadanie14;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Owca nadziana siarką dziedziczy po Owca.
 * Zjedzenie jej przez smoka powoduje zbieranie sie siarki.
 */
public class OwcaNadziana extends Owca {
    private double iloscSiarki; //ilosc siarki w kg

    public OwcaNadziana(String imie, double iloscSiarki) { //tworzy owce napelniona siarka
        super(imie);
        this.iloscSiarki = iloscSiarki;
    }

    @Override
    public double podajIloscSiarki() { //zwraca ilosc siarki
        return iloscSiarki;
    }

    public static OwcaNadziana losowa(double min, double max) { //generuja losowa nadziana owce z wartosci min a maks
        double siarka = ThreadLocalRandom.current().nextDouble(min, max);
        siarka = Math.round(siarka * 10.0) / 10.0;
        return new OwcaNadziana("Losowa", siarka);
    }

    @Override
    public String toString() {
        return "OwcaNadziana (" + podajImieOwcy() + ", siarka=" + iloscSiarki + "kg)";
    }
}
