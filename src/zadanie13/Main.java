package zadanie13;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(3);

        Thread p = new Thread(new Producent(q));
        Thread k = new Thread(new Konsument(q));

        p.start();
        k.start();
    }
}
