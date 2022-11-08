public class Palindromzahl {

        public static int spiegeln(int zahl) {
                int spiegelzahl = 0;
                while (zahl > 0) {
                        spiegelzahl *= 10;
                        spiegelzahl += zahl % 10;
                        zahl /= 10;
                }
                return spiegelzahl;
        }

        public static int spiegelAddieren(int zahl) {
                int spiegelzahl = spiegeln(zahl);
                return (spiegelzahl + zahl);
        }

        public static boolean palindromTest(int zahl) {
                int spiegelzahl = spiegeln(zahl);
                return (zahl == spiegelzahl);
        }

        public static void main(String[] args) {
                if (args.length != 1 || (Integer.parseInt(args[0]) < 0)) {
                        System.out.println("Error: wrong number of arguments");
                        return;
                }

                int input = Integer.parseInt(args[0]);
                int spiegelzahl = spiegeln(input);

                System.out.println(spiegelzahl);
                System.out.println(input + spiegelzahl);

                while (input != spiegelzahl) {
                        input += spiegeln(input);
                        spiegelzahl = spiegeln(input);
                }
                System.out.println(input);

        }
}
