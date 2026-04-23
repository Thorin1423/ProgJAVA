package zadanie7;

public class Kwadrat extends Figura { //kwadrat dziedziczy po figurze
    private double bok;

    public Kwadrat(double bok) { //konstruktor
        this.bok = bok;
    }

    @Override
    public double getPole() {
        return Math.pow(bok, 2); //bok do potegi 2
    }

    @Override
    public String toString() {
        return "S "  + getPole();
    }
}