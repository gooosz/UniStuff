public class Artikel {
    private String name;
    private double preis;
    private int bestand;

    public Artikel(String name, double preis, int bestand) {
        this.name = name;
        this.preis = preis;
        this.bestand = bestand;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    // reduziert bestand um 1
    public void reduziereBestand() {
        bestand--;
    }
}
