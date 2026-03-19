import java.util.Random;

public class Figura {
    private double promien;

    //konstruktor - ustala promien figury
    public Figura(double promien) {
        this.promien = promien;
    }

    //sprawdzenie czy miesci sie w kole
    public boolean czyPunktJestWewnatrz(double x, double y) {
        return (x * x) + (y * y) <= (promien * promien);
    }
}

