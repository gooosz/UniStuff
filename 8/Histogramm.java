public class Histogramm {
    public static void main(String[] args) {
        int[] a = {0,1,0,0,3,1};

        histogramm(a);
    }

    public static void histogramm(int[] a) {
        /*
         * anzahlAller[0]: anzahl von 0
         * anzahlAller[1]: anzahl von 1
         * usw.
         */
        int[] anzahlAller = new int[a.length];
        for (int i=0; i<a.length; i++) {
            anzahlAller[i] = anzahl(a, i);
        }

        int maxAnzahl = anzahlAller[0];
        int maxAnzahlVon = 0;
        for (int i=1; i<anzahlAller.length-1; i++) {
            if (maxAnzahl < anzahlAller[i]) {
                maxAnzahl = anzahlAller[i];
                maxAnzahlVon = i;
            }
        }


        for (int i=0; i<=5; i++) {
            System.out.print(i + ": ");

            // berechne anzahl
            int anzahl = anzahl(a, i);

            // output sterne
            int anzahlSterne = anzahlSterne(i, anzahl, maxAnzahl);
            for (int star=0; star<anzahlSterne; star++) {
                System.out.print("*");
            }
            System.out.print(" ");

            // output (amount, stars)
            System.out.print("(" + anzahl + "," + anzahlSterne + ")");

            System.out.println();
        }
    }

    // wieviele sterne i zugewiesen werden
    public static int anzahlSterne(int i, int anzahl, int maximalWert) {
        if (anzahl == maximalWert) {
            return 10;
        }
        return Math.round((anzahl * 10) / (float)maximalWert);
    }

    // wie oft i vorkommt
    public static int anzahl(int[] a, int i) {
        int counter = 0;
        for (int j=0; j<a.length; j++) {
            if (a[j] == i) {
                counter++;
            }
        }
        return counter;
    }


}
