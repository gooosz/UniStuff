import java.util.Scanner;
public class Lauflaengenkodierung {
        static Scanner scanner;
        static String output;

        public static void main(String[] args) {
                scanner = new Scanner(System.in);
                output = "";
                int prevInt = scanner.nextInt();
                int amount = 1;

                amountOfKette(prevInt, amount);
                System.out.println(output);
        }

        public static int amountOfKette(int prevInt, int prevAmount) {
                int amount = prevAmount;

                if (scanner.hasNextInt()) {
                        int i = scanner.nextInt();
                        if (prevInt == i) {
                                amount++;
                                return amountOfKette(prevInt, amount);
                        } else {
                                output += amount + "x" + prevInt + ".";
                                return amountOfKette(i, 1);
                        }
                } else {
                        output += amount + "x" + prevInt + ".";
                        return 0;
                }
        }
}
