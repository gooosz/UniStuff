public class Jahr {
        private int jahresAnzahl;
        private Tag[] tage;

        public Jahr(int jahr) {
                this.jahresAnzahl = jahr;
                tage = new Tag[365];
                for (int i=0; i<365; i++) {
                        tage[i] = new Tag();
                }
        }

        public void eintragen(int tag, String was, int prioritaet) {
                // tag-1 weil tage ab 0 beginnt aber tag ab 1
                Tag currTag = tage[tag-1];
                if (currTag.getVerabredung() != null && currTag.getPrioritaet() != 0) {
                        System.out.println("Fehler: " + currTag.getVerabredung());
                        return;
                }
                tage[tag-1].eintragen(was, prioritaet);
        }

        public String getTermin(int tag) {
                return tage[tag-1].getVerabredung();
        }

        public int getPrioritaet(int tag) {
                return tage[tag-1].getPrioritaet();
        }

        public int getBelegt() {
                int anzahl = 0;
                for (int i=0; i<tage.length; i++) {
                        if (tage[i].getVerabredung() != null && tage[i].getPrioritaet() != 0) {
                                anzahl++;
                        }
                }
                return anzahl;
        }

}
