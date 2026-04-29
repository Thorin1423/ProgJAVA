package zadanie11;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class ProstyShell {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String komenda = "";

        System.out.println("Uruchomiono Shell:");
        System.out.println("Wpisz 'quit' lub 'exit' aby zakonczyc dzialanie.");
        System.out.println("Wpisz 'ls' aby wyswietlic zawartosc biezacego katalogu.");
        System.out.println("Wpisz 'cp znak <skad> <dokad>' aby skopiowac plik znak po znaku.");
        System.out.println("Wpisz 'cp linia <skad> <dokad>' aby skopiowac plik linia po linii.");

        while (true) {
            System.out.print("$ "); //znak zachety
            komenda = sc.nextLine().trim();

            if (komenda.equals("quit") || komenda.equals("exit")) {
                System.out.println("Zamykanie...");
                break;

            } else if (komenda.equals("ls")) {
                listujKatalog("."); //wyswietlanie katalogu biezacego

            } else if (komenda.startsWith("cp ")) {
                String[] czesci = komenda.split(" "); //rozpisanie komendy na cp-tryb-skad-dokad
                if (czesci.length != 4) {
                    System.out.println("Uzycie: cp [znak|linia] [plik_pocz.] [plik_docelowy]");
                } else {
                    String tryb  = czesci[1];
                    String pocz  = czesci[2];
                    String doc = czesci[3];

                    if (tryb.equals("znak")) {
                        kopiujPoZnaku(pocz, doc); //kopia bajt po bajcie
                    } else if (tryb.equals("linia")) {
                        kopiujPoLinii(pocz, doc); //kopia po linia po linii
                    } else {
                        System.out.println("Nieznany tryb kopiowania: " + tryb + ". Uzyj 'znak' lub 'linia'.");
                    }
                }
            } else if (!komenda.isEmpty()) {
                System.out.println("Komenda: [" + komenda + "] nie jest znana!");
            }
        }
        sc.close();
    }

    public static void listujKatalog(String nazwaKatalogu) { //z zadania 7.2.1
        File katalog = new File(nazwaKatalogu);

        FilenameFilter filtr = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.endsWith(".txt")) return false; //pominiecie plikow .txt, reszta jest wyswietlana
                else {
                    return true;
                }
            }
        };

        File[] pliki = katalog.listFiles(filtr); //pobranie tablicy plikow z filtrem

        if (pliki == null) { //sprawdzenie czy katalog udalo sie odczytac
            System.out.println("Blad!: nie mozna odczytac katalogu.");
            return;
        }

        for (File f : pliki) {
            String kat = "";
            if (f.isDirectory()) kat = "/"; //ozn. katalogow "/"
            System.out.println(f.getName() + kat + "\t" + f.length() + " b" + "\t" + new Date(f.lastModified())); //wypisanie: nazwa, rozmiar w bajtach, data ostatniej modyfikacji
        }
    }

    public static void kopiujPoZnaku(String pocz, String doc) { //z zadania 7.2.2.
        try {
            FileInputStream  fis = new FileInputStream(pocz); //czytanie z pliku
            FileOutputStream fos = new FileOutputStream(doc); //zapisanie do pliku wyjsciowego

            while (fis.available() > 0) { //dopoki sa dane
                fos.write(fis.read()); //odczyt pojedynczego bajtu i zapis do pliku
            }

            fis.close();
            fos.close();

            System.out.println("Skopiowano znak po znaku: " + pocz + " -> " + doc);

        } catch (FileNotFoundException e) {
            System.out.println("Blad: Nie znaleziono pliku: " + pocz);
        } catch (IOException e) {
            System.out.println("Blad podczas kopiowania: " + e.toString()); //dla innych bledow
        }
    }

    public static void kopiujPoLinii(String pocz, String doc) { //z zadania 7.2.2
        try {
            BufferedReader br = new BufferedReader(new FileReader(pocz)); //buforowanie dla wydajnejszego odczytu i zapisu
            BufferedWriter bw = new BufferedWriter(new FileWriter(doc));

            String linia = br.readLine(); //wczytanie pierwszej linii
            while (linia != null) {
                bw.write(linia); //zapis linii
                bw.newLine(); //dodanie znaku nowej linii
                linia = br.readLine(); //wczytanie kolejnej linii
            }

            bw.flush(); //wymuszenie zapisu na dysk
            bw.close();
            br.close();

            System.out.println("Skopiowano linia po linii: " + pocz + " -> " + doc);

        } catch (FileNotFoundException e) {
            System.out.println("Blad: Nie znaleziono pliku: " + pocz);
        } catch (IOException e) {
            System.out.println("Blad podczas kopiowania: " + e.toString());
        }
    }
}