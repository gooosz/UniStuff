public class Polynom {
        private double[] koeffizienten;
        private static int aufrufe = 0;

        public Polynom(double[] koeffizienten) {
                // normalisieren
                int grad = koeffizienten.length;
                for (int i= koeffizienten.length-1; i>=0; i--) {
                        if (koeffizienten[i] == 0) {
                                grad--;
                        }
                }

                this.koeffizienten = new double[grad];
                for (int i=0; i<grad; i++) {
                        this.koeffizienten[i] = koeffizienten[i];
                }
                if (grad == 0) {
                        this.koeffizienten = new double[1];
                        this.koeffizienten[0] = 0;
                }
                aufrufe++;
        }

        public String toString() {
                String res = "";
                for (int i=koeffizienten.length-1; i>=0; i--) {
                        res += koeffizienten[i] + "*x^" + i;
                        if (i > 0) {
                                res += " + ";
                        }
                }
                return res;
        }

        public double auswerten(double x) {
                double res = 0;
                for (int i=0; i<koeffizienten.length; i++) {
                        res += koeffizienten[i] * Math.pow(x, i);
                }
                return res;
        }

        public static int getAnzahl() {
                return aufrufe;
        }
}
