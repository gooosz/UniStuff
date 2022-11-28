public class Weg {
        private Punkt[] punkte;

        public Weg(int x, int y) {
                punkte = new Punkt[]{new Punkt(x, y)};
        }

        public int getAnzahl() {
                return punkte.length;
        }

        public void verlaengern(Weg w) {
                Punkt[] neuePunkte = new Punkt[punkte.length + w.getAnzahl()];
                int i=0;
                for (; i<getAnzahl(); i++) {
                        neuePunkte[i] = punkte[i];
                }
                for (; i-punkte.length < w.getAnzahl(); i++) {
                        neuePunkte[i] = w.punkte[i - punkte.length];
                }
                punkte = neuePunkte;
        }

        public String toString() {
                String res = "";
                for (int i=0; i<getAnzahl(); i++) {
                        res += punkte[i].toString();
                        if (i < getAnzahl()-1) {
                                res += "-";
                        }
                }
                return res;
        }

}
