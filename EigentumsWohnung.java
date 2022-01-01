import java.text.DecimalFormat;

public class EigentumsWohnung extends Wohnung {
    Double Bm2;
    Double Rm2;

    EigentumsWohnung(int Id, Double Flaeche, int Zimmeranzahl, int Stockwerk, int Baujahr, int PLZ, String Strasse, int Hausnummer, int Top,  Double Bm2, Double Rm2) {
        super(Id, Flaeche, Zimmeranzahl, Stockwerk, Baujahr, PLZ, Strasse, Hausnummer, Top);
        this.Bm2 = Bm2;
        this.Rm2 = Rm2;
    }

    public Double gesamtKosten() {
        Double flaeche = super.getFlaeche();
        double zuschlag = 1.0 + (0.02 * super.getEtagen());
        return (this.Bm2 * flaeche + this.Rm2 * flaeche) * zuschlag;
    }

    public String toString() {
        Double flaeche = super.getFlaeche();
        DecimalFormat df = Wohnung.getDecimalFormat();
        int var10000 = this.getId();
        return "Typ:            EW\nId:             " + var10000 + "\nFlaeche:        " + df.format(flaeche) + "\nZimmer:         " + this.getZimmer() + "\nStock:          " + this.getEtagen() + "\nBaujahr:        " + this.getJahr() + "\nPLZ:            " + this.getPLZ() + "\nStrasse:        " + this.getStrasse() + "\nHausnummer:     " + this.getHausnummer() + "\nTop:            " + this.getTop() + "\nBetriebskosten: " + df.format(this.Bm2) + "\nRuecklage:      " + df.format(this.Rm2) + "\n";
    }
}