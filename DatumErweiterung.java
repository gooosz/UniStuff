import java.util.Scanner;

public class DatumErweiterung {
        static int j;
        static int m;
        static int t;
        static int s;
        static int m1;
        static int m2;

        static final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                j = Integer.parseInt(scanner.next());
                m = Integer.parseInt(scanner.next());
                t = Integer.parseInt(scanner.next());
                s = Integer.parseInt(scanner.next());
                m1 = Integer.parseInt(scanner.next());
                m2 = Integer.parseInt(scanner.next());

                if (!(1600 <= j && j <= 3000)
                        || !(1 <= m && m <= 12)
                        || !(1 <= t && t <= 31)
                        || !(0 <= s && s <= 23)
                        || !(0 <= m1 && m1 <= 59)
                        || !(0 <= m2 && m2 <= 40000))
                {
                        System.out.println("Error");
                }

                minutenAdd(m2);
                System.out.println(j+" "+m+" "+t+" "+s+" "+m1);
        }

        public static void minutenAdd(int min) {
                int overflow = 60;
                m1 += min;
                if (m1 >= overflow) {
                        stundenAdd(m1 / overflow);
                        m1 %= overflow;
                }
        }

        public static void stundenAdd(int hour) {
                int overflow = 24;
                s += hour;
                if (s >= overflow) {
                        tageAdd(s / overflow);
                        s %= overflow;
                }
        }

        public static void tageAdd(int day) {
                // months starts at index 0
                int overflow = months[m - 1];
                t += day;
                if (t > overflow) {
                        monatAdd(t / overflow);
                        // This may not work if t >= 2 * overflow
                        // because the next month has
                        t %= overflow;
                }
        }

        public static void monatAdd(int month) {
                // Note that @param: month is starting from 1
                int overflow = 12;
                // Make m start from zero, for easier logic
                m -= 1;
                m += month;
                if (m >= overflow) {
                        jahrAdd(m / overflow);
                        m %= overflow;
                }
                // Make m start from 1
                m += 1;
        }

        public static void jahrAdd(int year) {
                j += year;
        }
}
