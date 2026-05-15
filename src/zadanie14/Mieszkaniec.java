package zadanie14;

public abstract class Mieszkaniec { //abstraktcyjna klasa mieszkanca wsi
    private String imie; //imie mieszkanca

    public Mieszkaniec(String imie) { //tworzy mieszkanca o podanym imieniu
        this.imie = imie;
    }

    public void przywitajSieZeSmokiem(Smok smok) {
        if (!smok.czyZyje()) {
            // 1. Przypadek: Smok jest martwy
            System.out.println(smok.podajImie() + " nie zyje! Nie mozna sie z nim przywitac.");

        } else if (!smok.czyZiejeOgniem()) {
            // 2. Przypadek: Smok żyje i nie zieje ogniem
            System.out.println(imie + ": Czesc, " + smok.podajImie() + "!");

        } else {
            // 3. Przypadek: Pozostałe opcje, czyli smok żyje i zieje ogniem
            System.out.println(imie + " boi się przywitac — smok zieje ogniem!");
        }
    }

    public abstract void dzialaj(Smok smok); //glowna metoda mieszkanca wsi

    public String podajImie() { //zwraca imie mieszkanca
        return imie;
    }
}
