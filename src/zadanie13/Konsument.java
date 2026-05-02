package zadanie13;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Konsument implements Runnable {
    private Queue q;

    public Konsument(Queue q_) {
        q = q_;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(4000); //opoznienie pobierania o 4 sekundy
            } catch (InterruptedException ex) {
                Logger.getLogger(Konsument.class.getName()).log(Level.SEVERE, null, ex);
            }
            q.get();
        }
    }
}