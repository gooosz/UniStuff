public class WebShop {
    private Kunde[] kunden;
    private Artikel[] artikel;

    private int anzahlArtikel;
    private int anzahlKunden;

    public WebShop() {
        kunden = new Kunde[10];
        artikel = new Artikel[10];
    }

    private Artikel getArtikelFromString(String name) {
        Artikel a = null;
        for (int i=0; i<artikel.length; i++) {
            if (artikel[i] != null && artikel[i].getName().equals(name)) {
                a = artikel[i];
                break;
            }
        }
        return a;
    }

    public void neuerArtikel(String name, double preis, int anzahl) {
        artikel[anzahlArtikel] = new Artikel(name, preis, anzahl);
        anzahlArtikel++;
    }

    public Kunde neuerKunde(String vorname, String nachname) {
        return new Kunde(vorname, nachname);
    }

    public Kunde neuerKunde(String vorname, String nachname, double nachlass) {
        return new GuterKunde(vorname, nachname, nachlass);
    }

    public String bestellen(Kunde kunde, String[] artikelArray) {
        String rechnung = "";
        if (kunde instanceof GuterKunde) {
            rechnung += ("Rechnung fuer unseren guten Kunden " +
                    kunde.toString() + ", Preisnachlass " +
                    (((GuterKunde) kunde).getRabatt() * 100) + "%:\n");
        } else {
            rechnung += ("Rechnung fuer " + kunde.toString() + ":\n");
        }

        double gesamtPreis = 0;
        for (int i=0; i<artikelArray.length; i++) {
            Artikel currentArtikel = getArtikelFromString(artikelArray[i]);
            double artikelPreis = 0;
            if (currentArtikel == null) {
                rechnung += artikelArray[i] + " : nicht gefunden\n";
                continue;
            }
            // Artikel ist vorhanden
            if (currentArtikel.getBestand() == 0) {
                rechnung += currentArtikel.getName() + " : nicht mehr vorhanden\n";
                continue;
            }

            if (kunde instanceof GuterKunde) {
                artikelPreis = currentArtikel.getPreis() - currentArtikel.getPreis() * ((GuterKunde) kunde).getRabatt();
            } else {
                artikelPreis = currentArtikel.getPreis();
            }
            gesamtPreis += artikelPreis;
            rechnung += currentArtikel.getName() + " : " + artikelPreis + "\n";
            currentArtikel.reduziereBestand();
        }
        rechnung += "Gesamtpreis : " + gesamtPreis;
        return rechnung;
    }
}
