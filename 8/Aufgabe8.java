public class Aufgabe8 {
    public static void main(String[] args) {
        for (int i=20; i<100; i++) {
            System.out.println(zahlToString(i));
        }

    }

    public static String zahlToString(int zahl) {
        String out = "";

        int einer = zahl % 10;
        zahl /= 10;
        int zehner = zahl % 10;

        /*
         * Case 1: einer != 0
         *  // dreiundvierzig
         *
         * Case 2: einer == 0
         *  // vierzig
         */
        if (einer != 0) {
            out += einerToWord(einer);
            out += and();
        }
        out += zehnerToWord(zehner);
        return out;
    }

    public static String einerToWord(int zahl) {
        String[] zahlenwort = {
                "null",
                "ein",
                "zwei",
                "drei",
                "vier",
                "fuenf",
                "sechs",
                // TODO: sieben is as a zehner "siebzig"
                "sieben",
                "acht",
                "neun",
        };
        return zahlenwort[zahl];
    }

    public static String zehnerToWord(int zehner) {
        switch (zehner) {
            case 2: return ("zwan" + "zig");
            case 3: return (einerToWord(zehner) + "ßig");
            case 7: return ("sieb" + "zig");
            default: return (einerToWord(zehner) + "zig");
        }
    }

    public static String and() {
        return "und";
    }
}
