public class WegTest {
        public static void main(String[] args) {
                Weg w1 = new Weg(1, 1);
                Weg w2 = new Weg(2, 2);
                System.out.println(w1);
                System.out.println(w2);
                w1.verlaengern(w2);
                System.out.println(w1.toString());
        }
}
