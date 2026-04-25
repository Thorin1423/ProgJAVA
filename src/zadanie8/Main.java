package zadanie8;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--Maszyna dla Kol--");

        MaszynaLosujaca<Kolo> maszynaKola = new MaszynaLosujaca<>();
        maszynaKola.dodaj(new Kolo("Kolo nr.1"));
        maszynaKola.dodaj(new Kolo("Kolo nr.2"));
        maszynaKola.dodaj(new Kolo("Kolo nr.3"));
        maszynaKola.dodaj(new Kolo("Kolo nr.4"));

        System.out.println("Losowa lista kol: " + maszynaKola.losujListe());
        System.out.println("Losowanie jednego kola: " + maszynaKola.losujElement());

        System.out.println("\n--Maszyna dla Figur:--");

        MaszynaLosujaca<Figura> maszynaFigury = new MaszynaLosujaca<>();
        maszynaFigury.dodaj(new Figura("Kwadrat"));
        maszynaFigury.dodaj(new Figura("Trojkat"));
        maszynaFigury.dodaj(new Figura("Trapez"));
        maszynaFigury.dodaj(new Figura("Osmiokat"));

        System.out.println("Losowa lista Figur: " + maszynaFigury.losujListe());
        System.out.println("Losowanie jednej Figury: " + maszynaFigury.losujElement());
    }
}
