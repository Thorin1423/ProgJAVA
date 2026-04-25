package zadanie6;
import java.util.Scanner;
public class PrzegladarkaGrafuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wierzcholekString = sc.nextLine(); //wczytanie pierwszej lini
        String[] wierzcholki = wierzcholekString.split(" "); //oddzielenie spacji
        int n = wierzcholki.length; //pobranie do wielkosci macierzy

        int[][] macierz = new int[n][n]; //utworzenie nowej pustej macierzy sasiedztwa z zerami

        for (int i = 0; i < n; i++) { //wczytanie liczb
            String linia = sc.nextLine();
            String[] elementy = linia.split(" ");
            int zrodlo = elementy[0].charAt(0) - 'A';

            for (int j = 1; j < elementy.length; j++) {
                int cel = elementy[j].charAt(0) - 'A';
                macierz[zrodlo][cel] = 1;
            }
        }
        char startowyChar = sc.next().charAt(0); //wczytanie wierzcholka startowego
        int startowyIndeks = startowyChar - 'A';

        String jakiAlgorytm = sc.next();
        PrzegladanieGrafu graf;

        if (jakiAlgorytm.equals("DFS")) {
            graf = new DFS(macierz); //uruch. dfs
        } else {
            graf = new BFS(macierz);
        }
        graf.Algorytm(startowyIndeks); //uruchomienie przeszukania
        sc.close();
    }
} /*przykladowe dane wejsciowe:
A B C D E
A B
B A C D
C B E
D B
E C
A
BFS
wynik = A B C D E

A B C D E
A B C
B A D E
C A
D B
E B
A
BFS
wynik = A B C D E
*/
