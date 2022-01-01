/**
 * @author Finn Mueller
 * @id 11934549
 */

import java.text.DecimalFormat;

public class MietWohnung extends Wohnung{
    private final Double Mm2;
    private final int Mieter;
    MietWohnung(int Id, Double Flaeche, int Zimmeranzahl, int Stockwerk, int Baujahr, int PLZ, String Strasse, int Hausnummer, int Top, Double Mm2, int Mieter){
        super(Id, Flaeche, Zimmeranzahl, Stockwerk, Baujahr, PLZ, Strasse, Hausnummer, Top);
        this.Mm2 = Mm2;
        this.Mieter = Mieter;
    }
    public Double gesamtKosten() {
        Double flaeche = super.getFlaeche();
        Double zuschlag = 1.0D + 0.025D * ((double)this.Mieter-1);
        if (zuschlag > 1.1D) {
            zuschlag = 1.1D;
        }

        return flaeche * this.Mm2 * zuschlag;
    }

    public String toString() {
        Double flaeche = super.getFlaeche();
        DecimalFormat df = Wohnung.getDecimalFormat();
        int var10000 = this.getId();
        return "Typ:            MW\nId:             " + var10000 + "\nFlaeche:        " + df.format(flaeche) + "\nZimmer:         " + this.getZimmer() + "\nStock:          " + this.getEtagen() + "\nBaujahr:        " + this.getJahr() + "\nPLZ:            " + this.getPLZ() + "\nStrasse:        " + this.getStrasse() + "\nHausnummer:     " + this.getHausnummer() + "\nTop:            " + this.getTop() + "\nMiete/m2:       " + df.format(this.Mm2) + "\nAnzahl Mieter:  " + this.Mieter +"\n";
    }
}