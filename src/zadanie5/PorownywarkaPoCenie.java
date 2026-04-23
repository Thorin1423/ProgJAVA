class PorownywarkaPoCenie implements Porownywarka {
    @Override
    public int porownajPojazdy(Pojazd p1, Pojazd p2){
        if (p1.cena>p2.cena){
            return 1;
        } else if
        (p1.cena<p2.cena){
            return -1;
        }
        return 0;
    }
}
