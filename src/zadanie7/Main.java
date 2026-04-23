package zadanie7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int liczbaFigur = sc.nextInt(); //wczytanie ilosci liczb

        ListaD<Figura> lista = new ListaD<>(); //stworzenie pustej listy figur

        for (int i = 0; i < liczbaFigur; i++) {
            String typ = sc.next();
            double wymiar = sc.nextDouble();

            if (typ.equals("C")) {
                lista.addElement(new Kolo(wymiar));
            } else if (typ.equals("S")) {
                lista.addElement(new Kwadrat(wymiar));
            } else if (typ.equals("T")) {
                lista.addElement(new trojkatRownoboczny(wymiar));
            }
        }

        lista.bubbleSort();
        System.out.println();
        lista.wyswietl();

        sc.close();
    }
}