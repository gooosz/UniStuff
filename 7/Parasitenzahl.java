public class Parasitenzahl {

        /*
         * zahl = xn xn-1 xn-2 ... x2 x1
         * multZahlLetzteZiffer = x1 * (xn xn-1 xn-2 ... x2)
         * lastZifferToFront = (x1 xn xn-1 xn-2 ... x2
         */

        private static long lastZiffer(long zahl) {
                return (zahl % 10);
        }

        public static long lastZifferToFront(long zahl) {
                long lastZiffer = lastZiffer(zahl);
                zahl /= 10;
                long newNum = lastZiffer;

                long temp = zahl;
                while (temp > 0) {
                        newNum *= 10;
                        temp /= 10;
                }
                newNum += zahl;

                return newNum;
        }

        public static long multZahlByLetzteZiffer(long zahl) {
                long lastZiffer = lastZiffer(zahl);
                return (lastZiffer * zahl);
        }

        public static boolean istParasit(long zahl) {
                return (lastZifferToFront(zahl) == multZahlByLetzteZiffer(zahl));
        }

        public static void main(String[] args) {
                if (args.length != 1) {
                        System.out.println("Error: wrong number of arguments");
                        return;
                }

                int input = Integer.parseInt(args[0]);

                for (int i=1; i<=input; i++) {
                        if (istParasit(i)) {
                                System.out.println(i);
                        }
                }
        }
}
