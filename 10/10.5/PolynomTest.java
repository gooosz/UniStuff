public class PolynomTest {
        public static void main(String[] args) {
                Polynom p = new Polynom(new double[]{3, 2, 1});
                System.out.println(p.toString());
                System.out.println(p.auswerten(2));
                System.out.println(Polynom.getAnzahl());
        }
}
