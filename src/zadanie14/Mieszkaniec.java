package zadanie14;

public abstract class Mieszkaniec { //abstraktcyjna klasa mieszkanca wsi
    private String imie; //imie mieszkanca

    public Mieszkaniec(String imie) { //tworzy mieszkanca o podanym imieniu
        this.imie = imie;
    }

    public void przywitajSieZeSmokiem(Smok smok) { //proba przywitania sie ze smokiem
        if (!smok.czyZiejeOgniem()) { //mozna sie przywitac jak nie zieje ogniem
            System.out.println(imie + ": Czesc, " + smok.podajImie() + "!");
        } else { //nie mozna sie przywitac jesli zieje ogniem
            System.out.println(imie + " boi się przywitac — smok zieje ogniem!");
        }
    }

    public abstract void dzialaj(Smok smok); //glowna metoda mieszkanca wsi

    public String podajImie() { //zwraca imie mieszkanca
        return imie;
    }
}
