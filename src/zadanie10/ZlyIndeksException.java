package zadanie10;

public class ZlyIndeksException extends Exception {
    public ZlyIndeksException(String wiadomosc) {
        super(wiadomosc); //przekazanie wiadomosci do glownej klasy z bledami
    }
}