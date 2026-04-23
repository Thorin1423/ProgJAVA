package zadanie7;

public abstract class Figura implements Comparable<Figura> {

    public abstract double getPole();

    @Override
    public int compareTo(Figura inna) {
        return Double.compare(this.getPole(), inna.getPole()); //porownanie wlasnego pole z innym
    }
}