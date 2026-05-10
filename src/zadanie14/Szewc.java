package zadanie14;

import java.util.ArrayList;
import java.util.List;

public class Szewc extends Mieszkaniec { //klasa szewc dziedziczy po mieszkancu
    private List<OwcaNadziana> owce = new ArrayList<>(); //zapas owiec nadzianych przez szewca

    public Szewc(String imie) { //tworzy szewca o podanym imieniu
        super(imie);
    }

    public void przygotujOwce(double iloscSiarki) { //robi owce o danej ilosci siarki
        OwcaNadziana owca = new OwcaNadziana("Owca" + (owce.size() + 1), iloscSiarki);
        owce.add(owca);
        System.out.println(podajImie() + " przygotowal: " + owca);
    }

    public void przygotujLosowaOwce(double min, double max) { //robi losowa owce z zakresu min a max
        OwcaNadziana owca = OwcaNadziana.losowa(min, max);
        owce.add(owca);
        System.out.println(podajImie() + " przygotowal losowa: " + owca);
    }

    @Override
    public void dzialaj(Smok smok) { //karmienie smoka kolejnymi owcami dopoki smok zyje
        System.out.println("\n--- " + podajImie() + " karmi smoka ---");
        for (OwcaNadziana owca : owce) {
            if (!smok.czyZyje()) break;
            smok.zjedzOwce(owca);
        }
    }
}