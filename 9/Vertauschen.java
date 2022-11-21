public class Vertauschen {
    public static void main(String[] args) {
        String[] inhalt = vertauscheInhalt(args);
        String[] referenz = vertauscheReferenz(args);

        // Tests
        // Beide muessen gleiche Inhalte haben
        if (!testInhaltGleich(inhalt, referenz)) {
            System.out.println("Fehler: Inhalte stimmen nicht ueberein");
        }
        // aber beide muessen unterschiedliche referenzen haben
        if (testReferenzGleich(inhalt, referenz)) {
            System.out.println("Fehler: Referenzen muessen unterschiedlich sein");
        }
    }

    public static String[] vertauscheInhalt(String[] s) {
        String[] res= new String[s.length];

        for (int i=0; i<s.length; i++) {
            String curr = new String(s[s.length - i - 1]);
            res[i] = curr;
        }
        return res;
    }

    public static String[] vertauscheReferenz(String[] s) {
        String[] res= new String[s.length];

        for (int i=0; i<s.length; i++) {
            res[i] = s[s.length - i - 1];
        }
        return res;
    }

    public static boolean testInhaltGleich(String[] arg1, String[] arg2) {
        for (int i=0; i<arg1.length; i++) {
            if (!arg1[i].equals(arg2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean testReferenzGleich(String[] arg1, String[] arg2) {
        for (int i=0; i<arg1.length; i++) {
            if (arg1[i] != arg2[i]) {
                return false;
            }
        }
        return true;
    }
}
