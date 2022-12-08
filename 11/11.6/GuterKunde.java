public class GuterKunde extends Kunde{
    double rabatt;

    public GuterKunde(String vorname, String nachname, double rabatt) {
        super(vorname, nachname);
        this.rabatt = rabatt;
    }

    public double getRabatt() {
        return rabatt;
    }
}
