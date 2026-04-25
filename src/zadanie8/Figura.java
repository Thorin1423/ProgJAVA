package zadanie8;

public class Figura {
    private String nazwa;

    public Figura(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
