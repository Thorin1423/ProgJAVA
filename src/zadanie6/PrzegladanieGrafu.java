package zadanie6;
import java.util.LinkedList;

abstract class PrzegladanieGrafu {
    protected int[][] macierzSasiedztwa;
    protected LinkedList<Integer> doPojscia;

    public PrzegladanieGrafu(int[][] macierz) {
        this.macierzSasiedztwa = macierz; //zapisanie macierzy
        this.doPojscia = new LinkedList<>(); //stworzenie nowej listy
    }
    abstract void wstaw(int wierzcholek);
    abstract int pobierz();

    public void Algorytm(int wierzcholekPoczatkowy){
        boolean[] odwiedzone = new boolean[macierzSasiedztwa.length];

        wstaw(wierzcholekPoczatkowy); //ustaw. poczatkowe
        odwiedzone[wierzcholekPoczatkowy] = true;

        while(!doPojscia.isEmpty()){
            int aktualny = pobierz(); //pobranie wierzcholka
            System.out.print((char)(aktualny+'A')+ " ");
            for(int i=0; i<macierzSasiedztwa.length; i++){ //szukanie sasiadow w macierzy
                    if (macierzSasiedztwa[aktualny][i] == 1 && !odwiedzone[i]) { //sprawdzenie czy jest krawedzia (jedynka w macierzy) oraz czy sasiad nie byl odw.
                        odwiedzone[i] = true; //zaznaczenie obecnosci
                        wstaw(i);             //dorzucenie do stosu/kolejki
                    }
                }
            }
        }
}

class DFS extends PrzegladanieGrafu { //przeszukanie w glab - stos
    public DFS(int[][] macierz) {
        super(macierz);
    }

    @Override
    void wstaw(int wierzcholek) {
        doPojscia.addFirst(wierzcholek); //polozenie na gore
    }

    @Override
    int pobierz() {
        return doPojscia.removeFirst(); //zabranie z gory
    }
}

class BFS extends PrzegladanieGrafu { //przeszukiwanie wszerz - kolejka
    public BFS(int[][] macierz) {
        super(macierz);
    }

    @Override
    void wstaw(int wierzcholek) {
        doPojscia.add(wierzcholek); //dodanie na koniec elem.
    }

    @Override
    int pobierz() {
        return doPojscia.removeFirst(); //zabranie pierwszego elem.
    }
}