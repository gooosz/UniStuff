public class Tag {
        private String beschreibung;
        private int prioritaet;

        public Tag() {
                // kein termin
                beschreibung = null;
                prioritaet = 0;
        }
        public Tag(String beschreibung, int prioritaet) {
                this.beschreibung = beschreibung;
                this.prioritaet = prioritaet;
        }

        public void eintragen(String was, int prioritaet) {
                this.beschreibung = was;
                this.prioritaet = prioritaet;
        }

        public String getVerabredung() {
                return beschreibung;
        }

        public int getPrioritaet() {
                return prioritaet;
        }
}
