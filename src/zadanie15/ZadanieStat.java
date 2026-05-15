package zadanie15;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

 //implementacja Callable aby zwrocic Statystyki
public class ZadanieStat implements Callable<Statystyki> { //zadanie analizujace plik w osobnym watku
    private final int idZadania;
    private final Path sciezkaPliku;
    private final Path obecnyKatalog; //do znaku zachety

    public ZadanieStat(int idZadania, Path sciezkaPliku, Path obecnyKatalog) { //konstruktor
        this.idZadania = idZadania;
        this.sciezkaPliku = sciezkaPliku;
        this.obecnyKatalog = obecnyKatalog;
    }

    @Override
    public Statystyki call() throws Exception {
        long czasStart = System.currentTimeMillis(); //zapisanie czasu startu

        long liczbaSlow = 0;
        long liczbaZnakow = 0;
        //mapa przechowujaca kazde unikalne slowo jako klucz i l. jego wystapien jako wartosc
        Map<String, Integer> zliczeniaSlow = new HashMap<>();

        try (BufferedReader czytnik = Files.newBufferedReader(sciezkaPliku)) { //gwar. bezpiecznego zamkniecia
            String linia;
            while ((linia = czytnik.readLine()) != null) { //czytanie po kazdej linii
                liczbaZnakow += linia.length(); //wpisanie dlugosci linii do liczby znakow
                String[] slowa = linia.split("\\s+"); //podzielenie na jeden lub wiecej dow. b. znakow ulozonych obok siebie

                for (String token : slowa) {
                    String czysteSlowo = token.toLowerCase().replaceAll("[^a-z0-9]", ""); //przemiana do malych znakow i usuniecie wszystkiego co jest nie wazne
                    if (!czysteSlowo.isEmpty()) {
                        liczbaSlow++; //dodanie do mapy
                        zliczeniaSlow.put(czysteSlowo, zliczeniaSlow.getOrDefault(czysteSlowo, 0) + 1); //zwrocenie l. wyst. slowa, jesli nowy 
                    }
                }
                //symulacja obciazenia dla demon. wielowatkowosci
                Thread.sleep(1);
            }
        }

        long czasKoniec = System.currentTimeMillis();
        long czasSekundy = Math.max(1, (czasKoniec - czasStart) / 1000);

        //kom. o zakonczeniu dzialania
        System.out.println("\nZADANIE " + idZadania + " dla " + sciezkaPliku.getFileName() + " skonczylo dzialanie w " + czasSekundy + " sekund.");
        System.out.print(obecnyKatalog.toString() + " > ");

        Statystyki statystyki = new Statystyki();
        statystyki.nazwaPliku = sciezkaPliku.getFileName().toString();
        statystyki.liczbaSlow = liczbaSlow;
        statystyki.liczbaZnakow = liczbaZnakow;
        statystyki.czasSekundy = czasSekundy;
        statystyki.zliczeniaSlow = zliczeniaSlow;

        return statystyki;
    }
}
