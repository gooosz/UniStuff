import java.util.Scanner;

public class IbanBerechnen {

        public static String normalisedLaenderkennung(String laenderkennung) {
                return laenderkennung.toUpperCase();
        }

        public static String normaliseKontoNummer(String nr) {
                final int limit = 10;
                String normalised = "";
                if (nr.length() < limit) {
                        for (int i=0; i < limit-nr.length(); i++) {
                                normalised += "0";
                        }
                }
                normalised += nr;
                return normalised;
        }

        public static String bban(String blz, String kontoNr) {
                return (blz + normaliseKontoNummer(kontoNr));
        }

        public static String convertLaenderkennung(String laenderkennung) {
                String normLand = normalisedLaenderkennung(laenderkennung);

                final int A = 65;
                int pos1 = (normLand.charAt(0) % A) + 1;
                int pos2 = (normLand.charAt(1) % A) + 1;

                // must be between 10 ('A') and 35 ('Z')
                int umwandlung1 = pos1 + 9;
                int umwandlung2 = pos2 + 9;

                return (String.valueOf(umwandlung1) + String.valueOf(umwandlung2) + "00");
        }

        public static long mod(String bban_land) {
                if (bban_land.length() <= 9) {
                        return (Long.parseLong(bban_land) % 97);
                }

                long ersteNeunZiffern = Long.parseLong(bban_land.substring(0, 9));
                long mod = ersteNeunZiffern % 97;

                String newBban = mod + bban_land.substring(9);
                return mod(newBban);
        }

        public static String pruefZahl(long mod97Wert) {
                long differenz = 98 - mod97Wert;
                return (differenz < 10) ? ("0" + differenz) : String.valueOf(differenz);
        }


        public static String erzeugeIban(String laenderkennung, String blz, String nummer) {
                String iban = "";
                // Schritt 1
                String normLand = normalisedLaenderkennung(laenderkennung);
                // Schritt 2
                String normKontoNr = normaliseKontoNummer(nummer);
                // Schritt 3
                String bban = bban(blz, normKontoNr);
                // Schritt 4
                bban += convertLaenderkennung(laenderkennung);
                // Schritt 5
                long mod = mod(bban);

                // Schritt so halb
                // cut last 6 digits from bban cause no longer needed
                // those 6 digits were the converted laenderkennung
                // which was only needed for computing the modulus
                bban = bban.substring(0, bban.length() - 6);

                // Schritt 6
                String pruefzahl = pruefZahl(mod);
                // Schritt 7
                iban += normLand + pruefzahl + bban;
                return iban;
        }

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String laenderkennung = sc.next();
                String blz = sc.next();
                String kontoNr = sc.next();
                System.out.println(erzeugeIban(laenderkennung, blz, kontoNr));
        }
}
