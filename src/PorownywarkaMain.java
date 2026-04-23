public class PorownywarkaMain {
    public static void main(String[] args) {
        Pojazd auto = new Pojazd(4, 75000, 1700, 5);
        Pojazd rower = new Pojazd(2, 3000, 25, 1);
        Pojazd lodz = new Pojazd(0, 120000, 3200, 10);

        System.out.println("---Rozpoczynam sortowanie po cenie---");

        Porownywarka poCenie = new PorownywarkaPoCenie();
        //utworzenie nowej maszyny i przydzielenie jej tryb cena i maks. wart
        MaszynaSortujaca maszynaCenowa = new MaszynaSortujaca(poCenie, 10);

        maszynaCenowa.dodajPojazd(auto); //wrzucenie do maszyny
        maszynaCenowa.dodajPojazd(lodz);
        maszynaCenowa.dodajPojazd(rower);

        maszynaCenowa.sortuj();
        maszynaCenowa.wypisz();

        System.out.println("\n---Rozpoczynam sortowanie po wadze---");

        Porownywarka poWadze = new PorownywarkaPoWadze();

        MaszynaSortujaca maszynaWagowa = new MaszynaSortujaca(poWadze, 10);

        maszynaWagowa.dodajPojazd(auto);
        maszynaWagowa.dodajPojazd(lodz);
        maszynaWagowa.dodajPojazd(rower);

        maszynaWagowa.sortuj();
        maszynaWagowa.wypisz();
    }
}