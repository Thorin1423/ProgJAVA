import java.util.LinkedList;

public class Stos extends LinkedList {

    public void wstaw(Object o) {
        this.add(o);
    }

    public Object pobierz() {
        return this.removeLast();
    }

    public boolean czyPusty() {
        return this.isEmpty();
    }
}