public class Kalender {
        public static void main(String[] args) {
                Jahr j1 = new Jahr(2021);
                Jahr j2 = new Jahr(2022);

                j1.eintragen(45, "Klausur", 1);
                j2.eintragen(37, "Treffen", 5);

                if (j1.getTermin(17) == null) {
                        System.out.println("17. Tag ist frei");
                } else {
                        System.out.println("17. Tag ist belegt");
                }
                if (j1.getTermin(45) == null) {
                        System.out.println("45. Tag ist frei");
                } else {
                        System.out.println("45. Tag ist belegt");
                }
                System.out.println("Belegte Tage insgesamt: " + (j1.getBelegt() + j2.getBelegt()));
        }
}
