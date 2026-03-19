import java.util.Scanner;

public class Calkowanie {
    public double obliczKwadratowe(double a, double b, double c, double x1, double x2) {
        double wartoscx2= (a*x2*x2*x2)/3.0 + (b*x2*x2)/2.0 + (c*x2);
        double wartoscx1= (a*x1*x1*x1)/3.0 + (b*x1*x1)/2.0 + (c*x1);
        double wynik=0.0;
        return wynik= wartoscx2-wartoscx1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj a");
        Double a = scanner.nextDouble();
        System.out.println("Podaj b");
        Double b = scanner.nextDouble();
        System.out.println("Podaj c");
        Double c = scanner.nextDouble();
        System.out.println("Podaj x1"); //granica calkowania x1
        Double x1 = scanner.nextDouble();
        System.out.println("Podaj x2"); //granica calkowania x2
        Double x2 = scanner.nextDouble();

        System.out.println("Wynik: " + new Calkowanie().obliczKwadratowe(a, b, c, x1, x2));
    }
}