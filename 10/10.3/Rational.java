public class Rational {
    private int zaehler;
    private int nenner;

    public Rational(int n) {
        // größten nenner finden
        this.zaehler = n;
        this.nenner = 1;
    }
    public Rational(int zaehler, int nenner) {
        if (nenner == 0) {
            System.out.println("Fehler: Nenner ist 0");
            return;
        }

        int ggt = ggT(zaehler, nenner);
        //nenner soll immer positiv sein
        if (nenner < 0) {
            nenner = Math.abs(nenner);
            zaehler *= -1;
        }
        //bruch kuerzen
        this.zaehler = zaehler / ggt;
        this.nenner = nenner / ggt;
    }

    public int ggT(int a, int b) {
        if (a == 0) {
            return Math.abs(b);
        }
        if (b == 0) {
            return Math.abs(a);
        }
        // euklidischer algorithmus
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return Math.abs(a);
    }

    public Rational add(Rational r) {
        int neuerZaehler = this.zaehler + r.zaehler;
        int neuerNenner = this.nenner;

        if (this.nenner != r.nenner) {
            int zaehler1 = this.zaehler * r.nenner;
            int zaehler2 = r.zaehler * this.nenner;

            neuerZaehler = zaehler1 + zaehler2;
            neuerNenner = this.nenner * r.nenner;
        }
        return new Rational(neuerZaehler, neuerNenner);
    }

    public Rational sub(Rational r) {
        int neuerZaehler = this.zaehler - r.zaehler;
        int neuerNenner = this.nenner;

        if (this.nenner != r.nenner) {
            int zaehler1 = this.zaehler * r.nenner;
            int zaehler2 = r.zaehler * this.nenner;

            neuerZaehler = zaehler1 - zaehler2;
            neuerNenner = this.nenner * r.nenner;
        }
        return new Rational(neuerZaehler, neuerNenner);
    }

    public Rational mul(Rational r) {
        return new Rational(this.zaehler * r.zaehler,
                            this.nenner * r.nenner);
    }

    // division von bruechen ist nur
    // multiplikation mit kehrwert
    public Rational div(Rational r) {
        Rational kehrwertR = new Rational(r.nenner, r.zaehler);
        return mul(kehrwertR);
    }

    public String toString() {
        return (this.zaehler + "/" + this.nenner);
    }
}
