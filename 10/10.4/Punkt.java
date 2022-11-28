public class Punkt {
        private int x;
        private int y;

        public Punkt(int x, int y) {
                this.x = x;
                this.y = y;
        }

        public String toString() {
                return ("(" + this.x + "," + this.y + ")");
        }
}
