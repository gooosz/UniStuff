
public class Zahlendarstellung {
    public static int[] ermittleZiffern(int x, int b) {
        if (x == 0) {
            return new int[]{0};
        }

        int laengeInBase = anzahlZiffernInBase(x, b);
        int[] result = new int[laengeInBase];
        for (int i=0; i<laengeInBase; i++) {
            result[i] = x % b;
            x /= b;
        }
        return result;
    }

    private static int anzahlZiffern(int x) {
        int anzahl = 0;
        if (x == 0) {
            return 1;
        }

        while (x > 0) {
            anzahl++;
            x /= 10;
        }
        return anzahl;
    }

    public static int anzahlZiffernInBase(int x, int base) {
        int anzahl = 0;
        if (x == 0) {
            return 0;
        }

        while (x > 0) {
            anzahl++;
            x /= base;
        }
        return anzahl;
    }
}
