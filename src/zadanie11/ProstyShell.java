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
            System.out.print("$ ");
            komenda = sc.nextLine().trim();

            if (komenda.equals("quit") || komenda.equals("exit")) {
                System.out.println("Zamykanie...");
                break;

            } else if (komenda.equals("ls")) {
                listujKatalog(".");

            } else if (komenda.startsWith("cp ")) {
                String[] czesci = komenda.split(" "); //rozpisanie komendy na cp-tryb-skad-dokad
                if (czesci.length != 4) {
                    System.out.println("Uzycie: cp <znak|linia> <plik_pocz.> <plik_docelowy>");
                } else {
                    String tryb  = czesci[1];
                    String pocz  = czesci[2];
                    String doc = czesci[3];

                    if (tryb.equals("znak")) {
                        kopiujPoZnaku(pocz, doc);
                    } else if (tryb.equals("linia")) {
                        kopiujPoLinii(pocz, doc);
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

    // --- ls: listowanie zawartosci biezacego katalogu (zadanie 7.2.1) ---
    public static void listujKatalog(String nazwaKatalogu) {
        File katalog = new File(nazwaKatalogu);

        FilenameFilter filtr = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // pomijamy pliki .txt zgodnie z trescia zadania 7.2.1
                if (name.endsWith(".txt")) return false;
                else return true;
            }
        };

        File[] pliki = katalog.listFiles(filtr);

        // sprawdzamy czy katalog dal sie odczytac
        if (pliki == null) {
            System.out.println("Blad: nie mozna odczytac katalogu.");
            return;
        }

        for (File f : pliki) {
            String k = "";
            if (f.isDirectory()) k = "/";   // katalogi oznaczamy "/"
            System.out.println(f.getName() + k + "\t" + f.length() + " b" + "\t" + new Date(f.lastModified()));
        }
    }

    // --- cp znak: kopiowanie znak po znaku (zadanie 7.2.2 - KopiujPoZnaku) ---
    public static void kopiujPoZnaku(String skad, String dokad) {
        try {
            FileInputStream  fis = new FileInputStream(skad);
            FileOutputStream fos = new FileOutputStream(dokad);

            while (fis.available() > 0) {
                fos.write(fis.read());
            }

            fis.close();
            fos.close();

            System.out.println("Skopiowano znak po znaku: " + skad + " -> " + dokad);

        } catch (FileNotFoundException e) {
            System.out.println("Blad: Nie znaleziono pliku: " + skad);
        } catch (IOException e) {
            System.out.println("Blad podczas kopiowania: " + e.toString());
        }
    }

    // --- cp linia: kopiowanie linia po linii (zadanie 7.2.2 - KopiujPoLinii) ---
    public static void kopiujPoLinii(String skad, String dokad) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(skad));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dokad));

            String linia = br.readLine();
            while (linia != null) {
                bw.write(linia);
                bw.newLine();
                linia = br.readLine();
            }

            bw.flush();   // wymuszamy zapis buforowanych danych na dysk
            bw.close();
            br.close();

            System.out.println("Skopiowano linia po linii: " + skad + " -> " + dokad);

        } catch (FileNotFoundException e) {
            System.out.println("Blad: Nie znaleziono pliku: " + skad);
        } catch (IOException e) {
            System.out.println("Blad podczas kopiowania: " + e.toString());
        }
    }
}