package zadanie12;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nazwaPliku = "listaSerial.txt";

        SerializowanaLista lista = new SerializowanaLista(); //tworzenie nowej listy

        try { //odczyt pliku
            ObjectInputStream wejscie = new ObjectInputStream(new FileInputStream(nazwaPliku));
            lista = (SerializowanaLista) wejscie.readObject();
            wejscie.close();
            System.out.println("Wczytano liste z pliku.");
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku lub jest pusty! Tworze nowa liste.");
        }

        Scanner sc = new Scanner(System.in); //wczytanie z klaw. i dodanie do listy
        System.out.print("Wpisz tekst, ktory chcesz dodac do listy: ");
        String wpisanyTekst = sc.nextLine();

        lista.dodaj(wpisanyTekst);

        lista.wypisz();

        try { //zapisanie nowej listy do pliku
            ObjectOutputStream wyjscie = new ObjectOutputStream(new FileOutputStream(nazwaPliku));
            wyjscie.writeObject(lista);
            wyjscie.close();
            System.out.println("Lista zostala pomyslnie zapisana do pliku 'listaSerial.txt'.");
        } catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu: " + e.getMessage());
        }
    }
}
