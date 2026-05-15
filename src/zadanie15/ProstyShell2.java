package zadanie15;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProstyShell2 {
    //przechowuje sciezke do aktualnego katalogu, domyslnie roboczy programy
    private static Path obecnyKatalog = Paths.get(System.getProperty("user.dir")).toAbsolutePath().normalize();
    //pula watkow
    private static final ExecutorService wykonawca = Executors.newFixedThreadPool(4);
    //licznik dla watkow (ID)
    private static final AtomicInteger licznikZadan = new AtomicInteger(1);
    //mapa przechowujaca obiekty Future wynikow obliczen Statystyk
    private static final Map<Integer, Future<Statystyki>> mapaZadan = new ConcurrentHashMap<>();
    //mapa przechowujaca ID z nazwa analizowanego pliku
    private static final Map<Integer, String> mapaPlikow = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prosty Shell 2 - Interaktywny analizator plikow.");
        System.out.println("Komendy: CD, LS, STAT, INFO, EXIT");

        while (true) { //glowna petla
            System.out.print("\n" + obecnyKatalog.toString() + " $ "); //znak zachety z obecnym katalogiem
            if (!sc.hasNextLine()) break; //zabezp. przed bledem
            String wejscie = sc.nextLine().trim(); //ignorowanie samych enterow
            if (wejscie.isEmpty()) continue;

            String[] czesci = wejscie.split("\\s+"); //podzielenie ciag znakow na tablice po spacjach
            String komenda = czesci[0].toUpperCase(); //[0] komenda, [1] argument

            try {
                switch (komenda) { //rozpoznanie i obsluga komend
                    case "CD": //zmiana katalogu
                        if (czesci.length > 1) {
                            obslugaCd(czesci[1]);
                        } else {
                            System.out.println("Blad: Podaj nazwę folderu! Użycie: CD <nazwa_folderu>");
                        }
                        break;
                    case "LS": //wyswietlenie plikow .txt w katalogu
                        obslugaLs();
                        break;
                    case "STAT": //analiza pliku tekstowego
                        if (czesci.length > 1) {
                            obslugaStat(czesci[1]);
                        } else {
                            System.out.println("Blad: Podaj nazwe pliku! Użycie: STAT <nazwa_pliku.txt>");
                        }
                        break;
                    case "INFO": //pobranie wynikow analizy
                        if (czesci.length > 1) {
                            obslugaInfo(Integer.parseInt(czesci[1]));
                        } else {
                            System.out.println("Blad: Podaj ID zadania! Użycie: INFO <numer_id>");
                        }
                        break;
                    case "EXIT": //bezpiecznie wyjscie
                        System.out.println("Zamykanie...");
                        wykonawca.shutdown();
                        return;
                    default:
                        System.out.println("Nieznana komenda: " + komenda);
                }
            } catch (NumberFormatException e) {
                System.out.println("Blad: Argument komendy INFO musi być liczbą calkowita.");
            } catch (Exception e) {
                System.out.println("Blad: " + e.getMessage());
            }
        }
    }

    private static void obslugaCd(String folder) {
        Path nowy = obecnyKatalog.resolve(folder).normalize(); //utw. nowej sciezki poprzez dodanie argumentu do obecnej i norm.
        if (Files.isDirectory(nowy)) obecnyKatalog = nowy;
        else System.out.println("Folder nie istnieje!");
    }

    private static void obslugaLs() { //wykorzystanie filtra *.txt
        try (DirectoryStream<Path> strumien = Files.newDirectoryStream(obecnyKatalog)) {
            for (Path p : strumien) System.out.println(" - " + p.getFileName());
        } catch (IOException e) {
            System.out.println("Blad LS!");
        }
    }

    private static void obslugaStat(String plik) {
        Path sciezka = obecnyKatalog.resolve(plik).normalize();
        if (!Files.isRegularFile(sciezka)) {
            System.out.println("Plik nie istnieje.");
            return;
        }
        int id = licznikZadan.getAndIncrement(); //pobranie obecnej wartosci licznika i zwiekszenie
        mapaPlikow.put(id, plik);
        ZadanieStat zadanie = new ZadanieStat(id, sciezka, obecnyKatalog); //utworzenie obiektu zadania
        Future<Statystyki> future = wykonawca.submit(zadanie); //przekazanie zadania do puli watkow jako obiekt future
        mapaZadan.put(id, future);
        System.out.println("File " + plik + " is analyzed in task " + id);
    }

    private static void obslugaInfo(int id) {
        if (!mapaZadan.containsKey(id)) {
            System.out.println("Brak zadania!");
            return;
        }
        Future<Statystyki> f = mapaZadan.get(id);
        if (!f.isDone()) { //sprawdzenie czy watek zakonczyl prace
            System.out.println(mapaPlikow.get(id) + " is still analyzed");
        } else {
            try { //pobranie wyniku za pomoca get
                Statystyki s = f.get();
                System.out.println("file: " + s.nazwaPliku);
                System.out.println("words: " + s.liczbaSlow);
                System.out.println("characters: " + s.liczbaZnakow);
                System.out.println("processing time: " + s.czasSekundy + " seconds");
                System.out.println("words stats:");
                s.zliczeniaSlow.entrySet().stream() //strumieniowanie po wpisach w mapie statystyk zliczen slow
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //sort. malejcae wzgledem liczby wyst.
                        .limit(4) //ogr. do 4 slow
                        .forEach(e -> System.out.println("  " + e.getKey() + " " + e.getValue()));
            } catch (Exception e) {
                System.out.println("Blad INFO.");
            }
        }
    }
}