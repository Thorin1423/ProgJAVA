package zadanie7;

public class trojkatRownoboczny extends Figura {
    private double bok;

    public trojkatRownoboczny(double bok) {
        this.bok = bok;
    }

    @Override
    public double getPole() {
        return Math.pow(bok, 2)*Math.sqrt(3)/4.0;
    }

    @Override
    public String toString() {
        return String.format(java.util.Locale.US, "T %.3f", getPole());
    }
}