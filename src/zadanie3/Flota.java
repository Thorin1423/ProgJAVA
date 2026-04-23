public class Flota {
    Okret[] tablicaOkretow; //tablica okretow
    int obecnaLiczbaOkretow=0;

    public Flota(int maxNiszczycieli, int maxLotniskowcow){ // //tworzy tablice o rozm. rownym maks. l. wszystkich okretow
        tablicaOkretow = new Okret[maxNiszczycieli+maxLotniskowcow];
    }

    public void dodajDoFloty (Okret nowyOkret){
        if (obecnaLiczbaOkretow < tablicaOkretow.length){ //jesli jest miejsce
            tablicaOkretow[obecnaLiczbaOkretow]=nowyOkret; //dodanie do tablicy
            obecnaLiczbaOkretow++; //zwiekszenie licznika
        } else {
            System.out.println("Brak wolnego miejsca we flocie!");
        }
    }

    public int silaFloty(){
        int sumaSily=0;
        int sumaPasazerow=0;
        int sumaDzial=0;
        int silaFloty=0;

        for (int i=0; i<obecnaLiczbaOkretow; i++){ //dla kazdego obrotu
            if (tablicaOkretow[i]!=null){ //jesli nie jest pusta
                sumaPasazerow += tablicaOkretow[i].liczbaPasaz; //dodanie liczby pasazerow
            }
            if (tablicaOkretow[i] instanceof Niszczyciel){ //sprawdzenie czy jest klasa Niszczyciel
                Niszczyciel niszczyc =  (Niszczyciel) tablicaOkretow[i]; //rzutowanie
                sumaSily += niszczyc.silaRazenia; //dodanie wartosci
                sumaDzial += niszczyc.iloscDzial;
            }
        }
        silaFloty = sumaSily+sumaPasazerow+sumaDzial;
        return silaFloty;
    }

    public String toString(){
        return "Sila floty wynosi: " + silaFloty();
    } //nadpisanie metody toString

    public static void main(String[] args) {
        Flota flota = new Flota(3,1);
        Niszczyciel n1 = new Niszczyciel(2,1,100,20,1,25,5);
        flota.dodajDoFloty(n1);
        Lotniskowiec l1 = new Lotniskowiec(3,1,340,30,2,5, 1,35);
        flota.dodajDoFloty(l1);

        System.out.println(flota);
    }
}
