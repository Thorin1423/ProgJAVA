package zadanie7;

public class Kolo extends Figura {
    private double promien;

    public Kolo(double promien) {
        this.promien = promien ;
    }

    @Override
    public double getPole() {
        return Math.PI * Math.pow(promien, 2); // PI * r^2 = pole kola
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "C %.3f", getPole());
    }
}