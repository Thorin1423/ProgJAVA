package zadanie13;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producent implements Runnable {
    private Queue q;

    public Producent(Queue q_) {
        q = q_;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(3000); //opoznienie produkcji o 3 sekundy
            } catch (InterruptedException ex) {
                Logger.getLogger(Producent.class.getName()).log(Level.SEVERE, null, ex);
            }
            int element = r.nextInt(100); //losowanie liczby
            q.put(element);
        }
    }
}