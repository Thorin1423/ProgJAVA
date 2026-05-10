package zadanie14;

public class Smok implements IPalacy, IAktywny {
    private static final double progZmeczenia = 10.0; //przy 10 kg siarki smok staje sie zmeczony
    private static final double progSmierci = 20.0; //20 kg siarki jest to granica wytrzymalosci smoka (smierci)

    private String podajImie; //podaje podajImie smoka
    private boolean niebezpieczny; //podaje czy smok jest niebezpieczny
    private boolean czyZyje; //zwraca czy smok zyje (T/F)
    private double podajIloscSiarki; //zwraca ilosc siarki

    public Smok(String podajImie, boolean niebezpieczny) { //tworzy smoka o danym imieniu
        this.podajImie = podajImie;
        this.niebezpieczny = niebezpieczny;
        this.czyZyje = true;
        this.podajIloscSiarki = 0;
    }

    @Override
    public void ziewanieOgniem() { //jesli smok zyje i nie jest zmeczony to ziewa ogniem
        if (czyZiejeOgniem()) {
            System.out.println(podajImie + ": [zieje ogniem]");
        } else {
            System.out.println(podajImie + " nie moze ziac ogniem.");
        }
    }

    @Override
    public boolean czyZyje() {
        return czyZyje;
    } //zwrocenie czy smok zyje (T/F)

    @Override
    public boolean czyZiejeOgniem() { //sprawdzenie czy smok moze ziac ogniem (zwrocenie T/F)
        return czyZyje && niebezpieczny && podajIloscSiarki < progZmeczenia; //warunek to czy zyje i ma ponizej 10kg siarki
    }

    public void zjedzOwce(Owca owca) { //smok zjada owce
        if (!czyZyje) return; //jesli smok zyje
        System.out.println(podajImie + " zjada " + owca);

        podajIloscSiarki += owca.podajIloscSiarki();

        if (podajIloscSiarki >= progSmierci) { //jesli ilosc siarki przekracza prog smierci
            czyZyje = false; //smok nie zyje
            System.out.println(podajImie + " zjadl za dużo siarki i umarl!");
        } else if (podajIloscSiarki >= progZmeczenia) { //jesli ilosc siarki przekracza prog zmeczenia to smok jest zmeczony
            System.out.println(podajImie + " jest zmeczony i przestał ziać ogniem. (suma siarki: " + podajIloscSiarki + " kg)");
        }
    }

    public String podajImie() {
        return podajImie;
    } //zwraca imie smoka

    @Override
    public String toString() { //nadpisanie metody toString
        return "Smok(" + podajImie + ", zyje=" + czyZyje + ", siarka=" + podajIloscSiarki + "kg)";
    }
}
