package zadanie9;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Synonimy {
    public static void main(String[] args) {

        File file = new File("slownik.txt");

        if (!file.exists()) { //sprawdzenie czy plik istnieje
            System.out.println("Plik slownik.txt nie istnieje!");
            System.exit(1);
        }

        Map<String, List<String>> slownik = new HashMap<>(); //inic. pustej mapy

        try {
            List<String> linie = Files.readAllLines(Path.of("slownik.txt")); //wczytanie linijek z pliku do listy

            for (String linia : linie) { //przejscie po kazdej linijce
                String[] slowa = linia.split(":");
                slownik.put(slowa[0].trim(), List.of(slowa[1].trim().split(",")));
                //klucz to slowo [0],pobranie slowa [1], podzielenie po przecinkach i otworzenie listy //trim do biaych znakow
            }
            System.out.println("Slownik wczytany poprawnie! Rozmiar: " + slownik.size());
        } catch (Exception e) {
            System.out.println("Blad wczytania: " + e.getMessage());
        }

        if (args.length == 0) {
            System.out.println("Podaj słowo do wyszukania!");
            return;
        }

        String szukaneSlowo = args[0]; //pierwsze slowo z arg.

        if (slownik.containsKey(szukaneSlowo)) { //sprawdzenie czy w slowniku znajduje sie klucz pasujacy do danego slowa
            System.out.println("Synonimy dla slowa [" + szukaneSlowo + "]");
            System.out.println(slownik.get(szukaneSlowo));
        } else {
            System.out.println("Brak slowa [" + szukaneSlowo + "] w slowniku.");
            System.out.println("Szukam wyrazu bliskoznacznego...");

            String najblizsze = slownik.keySet().stream() //pobranie wszystkie klucze z slownika do strumienia
                    .min(Comparator.comparingInt(klucz -> StringUtils.getLevenshteinDistance(szukaneSlowo, klucz))) //wyszukanie najb. slowa na podstawie bib. Levenshteina
                    .orElse("Brak slow w slowniku");

            System.out.println("Czy chodzilo Ci o: [" + najblizsze + "]?");
            System.out.println("Jego synonimy to: " + slownik.get(najblizsze));
        }
    }
}