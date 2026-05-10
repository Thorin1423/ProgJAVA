package zadanie14;

public class Wioska { //glowna klasa main

    public static void main(String[] args) { //punkt startowy program
        //sa 3 smoki (1 niebezpieczny)
        Smok smaug  = new Smok("Smaug", true);   //niebezpieczny
        Smok zielus = new Smok("Zielus", false);  //roslinozerny
        Smok brzos = new Smok("Brzos", false); //owocozerny

        //jest 2 mieszkancow
        Szewc szewc = new Szewc("Dratewka");
        Kucharz kucharz = new Kucharz("Bartlomiej");

        System.out.println("--- Smok atakuje wioske! ---"); //smok zieje ogniem
        smaug.ziewanieOgniem();

        kucharz.dzialaj(smaug); //kucharz sprawdza smoka smauga i ucieka

        //szewc przygotowuje owce dla smauga
        szewc.przygotujOwce(6.0);
        szewc.przygotujOwce(8.0);
        szewc.przygotujOwce(8.0);
        szewc.przygotujOwce(5.0);
        szewc.przygotujLosowaOwce(1.0, 4.0);

        szewc.dzialaj(smaug); //szewca karmi smoka (smauga) owcami

        kucharz.dzialaj(smaug); //kucharz ponownie sprawdza smoka, jest bezpieczny

        //mieszkancy witaja się ze smokami
        System.out.println("\n--- Mieszkancy witaja sie ze smokami ---");
        szewc.przywitajSieZeSmokiem(smaug);
        szewc.przywitajSieZeSmokiem(zielus);
        kucharz.przywitajSieZeSmokiem(brzos);

        //roslinozerne smoki jedza zwykle owce (bez efektu)
        System.out.println("\n--- Roslinozerne smoki jedza ---"); //roslinozerne smoki jedza owce bez efektow
        zielus.zjedzOwce(new Owca("Franek"));
        brzos.zjedzOwce(new Owca("Basia"));
    }
}
