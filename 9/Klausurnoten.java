public class Klausurnoten {

    /*
     * @params punkte[i] gibt erreichte Punktzahl von i-ter Person
     * @params punktgrenze ist immer .length = 4
     * -> also immer
     * punktgrenze[0]: ab wieviele punkte man 4 bekommt
     * punktgrenze[1]: ab wieviele punkte man 3 bekommt
     * punktgrenze[2]: ab wieviele punkte man 2 bekommt
     * punktgrenze[3]: ab wieviele punkte man 1 bekommt
     *
     * also:
     * 0 <= x <= punktgrenze[0]:                5
     * punktgrenze[0] < x <= punktgrenze[1]:    4
     * punktgrenze[1] < x <= punktgrenze[2]:    3
     * punktgrenze[2] < x <= punktgrenze[3]:    2
     * punktgrenze[3] < x:                      1
     *
     */
    public static void
    verarbeiteKlausurPunktzahl(int[] punkte, int[] punktgrenze) {
        // Ausgabe 1
        System.out.println(anzahlTeilnehmer(punkte));
        // Ausgabe 2
        int[] besteSchlechtesteNote = maxundminNote(punkte, punktgrenze);
        for (int i=0; i<besteSchlechtesteNote.length; i++) {
            System.out.print(besteSchlechtesteNote[i]);
            /*
             * Praktomat könnte meckern dass die Ausgabe
             * "x y "
             * lautet statt
             * "x y"
             * deshalb beim letzten element leerzeichen weglassen
             */
            if (i < besteSchlechtesteNote.length-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        // Ausgabe 3
        int[] bestandenNichtbestanden = anzahlBestandenNichtbestanden(punkte, punktgrenze);
        for (int i=0; i<bestandenNichtbestanden.length; i++) {
            System.out.print(bestandenNichtbestanden[i]);
            /*
             * Praktomat könnte meckern dass die Ausgabe
             * "x y "
             * lautet statt
             * "x y"
             * deshalb beim letzten element leerzeichen weglassen
             */
            if (i < bestandenNichtbestanden.length-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        // Ausgabe 4
        System.out.println(getDurchschnitt(punkte));
        // Ausgabe 5
        for (int i=0;i<=punktgrenze.length; i++) {
            int anzahlNote = anzahlVonNote(i+1, punkte, punktgrenze);
            System.out.println((i+1) + " " + anzahlNote);
        }
    }

    private static int anzahlTeilnehmer(int[] punkte) {
        return punkte.length;
    }
    /*
     * [0]: beste Note
     * [1]: schlechteste Note
     */
    private static int[] maxundminNote(int[] punkte, int[] punktgrenzen) {
        int besteNote = getNoteFromPunkt(punkte[0], punktgrenzen);
        int schlechtesteNote = getNoteFromPunkt(punkte[0], punktgrenzen);

        for (int i=0; i<punkte.length-1; i++) {
            int naechsteNote = getNoteFromPunkt(punkte[i+1], punktgrenzen);
            // check for beste note
            // je kleiner die Note desto besser
            if (besteNote > naechsteNote) {
                besteNote = naechsteNote;
            }
            // check for schlechteste note
            if (schlechtesteNote < naechsteNote) {
                schlechtesteNote = naechsteNote;
            }
        }
        return new int[]{besteNote, schlechtesteNote};
    }

    // @returns the note (1 - 5) associated with punkte in punktgrenzen[]
    private static int getNoteFromPunkt(int punkte, int[] punktgrenzen) {
        int min = 0;
        int max = 0;
        for (int i=0; i<punktgrenzen.length; i++) {
            max = punktgrenzen[i];
            if (min <= punkte && punkte <= max) {
                // gibt die korrekte notenanzahl an (1 - 5)
                return (punktgrenzen.length - i + 1);
            }
            min = max;
        }
        // liegt im 1er Bereich
        return 1;
    }

    // returns if a student with punkte in punktgrenzen has note <= 4
    private static boolean hatBestanden(int punkte, int[] punktgrenzen) {
        int note = getNoteFromPunkt(punkte, punktgrenzen);
        return (note <= 4);
    }
    /*
     * [0]: anzahl bestanden
     * [1]: anzahl nicht bestanden
     */
    private static int[]
    anzahlBestandenNichtbestanden(int[] punkte, int[] punktgrenzen) {
        int anzahlBestanden = 0;
        for (int i=0; i<punkte.length; i++) {
            if (hatBestanden(punkte[i], punktgrenzen)) {
                anzahlBestanden++;
            }
        }
        // {bestandene, der rest(nicht bestanden)}
        return new int[]{anzahlBestanden, punkte.length-anzahlBestanden};
    }

    private static double getDurchschnitt(int[] punkte) {
        double sum = 0;
        for (int i=0; i<punkte.length; i++){
            sum += punkte[i];
        }
        return (sum / punkte.length);
    }

    private static int
    anzahlVonNote(int note, int[] punkte, int[] punktgrenzen) {
        int anzahl = 0;
        for (int i=0; i<punkte.length; i++) {
            int currNote = getNoteFromPunkt(punkte[i], punktgrenzen);
            if (currNote == note) {
                anzahl++;
            }
        }
        return anzahl;
    }
}
