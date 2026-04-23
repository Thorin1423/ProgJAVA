class PorownywarkaPoWadze implements Porownywarka {
    @Override
    public int porownajPojazdy(Pojazd p1, Pojazd p2){
        if (p1.waga>p2.waga){
            return 1;
        } else if
        (p1.waga<p2.waga){
            return -1;
        }
        return 0;
    }
}

