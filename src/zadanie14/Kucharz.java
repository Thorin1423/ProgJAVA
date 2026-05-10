package zadanie14;

public class Kucharz extends Mieszkaniec implements IStrachliwy { //kucharz dziedziczy po mieszkancu i implementuje Istrachliwy

    public Kucharz(String imie) { //tworzy kucharza o podanym imieniu
        super(imie);
    }

    @Override
    public void uciekaj() { //kucharz gdy jest w niebezpieczenstwie ucieka
        System.out.println(podajImie() + " ucieka!");
    }

    @Override
    public void dzialaj(Smok smok) { //dzialanie kucharza
        System.out.println("\n--- " + podajImie() + " sprawdza smoka ---");
        if (smok.czyZiejeOgniem()) { //jesli zieje ogniem to ucieka
            uciekaj();
        } else { //jesli nie to wita sie ze smokiem
            przywitajSieZeSmokiem(smok);
        }
    }
}
