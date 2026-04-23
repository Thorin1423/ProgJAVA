import java.util.Random;

public class MonteCarlo {

    public static void main(String[] args) {

        //tworze obiekt kolo o promieniu 1
        Figura figura = new Figura(1.0);
        policz(figura, 1000);
        System.out.println();
        policz(figura, 10000);
    }

    public static void policz(Figura figura, int liczbaLosowan) {
        //obiekt do losowania - random
        Random random = new Random();
        int punktyWewnatrz = 0;

        for (int i = 0; i < liczbaLosowan; i++) {
            //losowanie wspol. x oraz y
            double x = random.nextDouble(); //losuje liczbe z przedzialu <0,1)
            double y = random.nextDouble(); //losuje liczbe z przedzialu <0,1)
            //sprawdzenie czy Pnkt jest wewn.
            if (figura.czyPunktJestWewnatrz(x, y)) {
                punktyWewnatrz++;
            }
        }
        //wzor MonteCarlo
        double wynik = 4.0 * punktyWewnatrz / liczbaLosowan;
        System.out.println("Liczba losowan: " + liczbaLosowan);
        System.out.println("Punkty wewnatrz: " + punktyWewnatrz);
        System.out.println("Przyblizenie: " + wynik);
    }
}
