/**
 * @author Finn Mueller
 * @id 11934549
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Wohnung implements Serializable {
    private final int Id;
    private final Double Flaeche;
    private final int Zimmeranzahl;
    private final int Stockwerk;
    private final int Baujahr;
    int PLZ;
    String Strasse;
    int Hausnummer;
    int Top;

    Wohnung(int Id, Double Flaeche, int Zimmeranzahl, int Stockwerk, int Baujahr, int PLZ, String Strasse, int Hausnummer, int Top){
        try{
            if(Baujahr > LocalDate.now().getYear()){
                throw new IllegalArgumentException("Baujahr ungueltig.");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Error: " +e.getMessage());
        }
        this.Id = Id;
        this.Flaeche = Flaeche;
        this.Zimmeranzahl = Zimmeranzahl;
        this.Stockwerk = Stockwerk;
        this.Baujahr = Baujahr;
        this.PLZ = PLZ;
        this.Strasse = Strasse;
        this.Hausnummer = Hausnummer;
        this.Top = Top;
    }

    public int alter(){
        return LocalDate.now().getYear() - Baujahr;
    }
    public Double gesamtKosten(){
        return null;
    }
    public static DecimalFormat getDecimalFormat() {
        return new DecimalFormat("0.00");
    }

    public int getId() {
        return this.Id;
    }
    public double getFlaeche() {
        return this.Flaeche;
    }

    public int getZimmer() {
        return this.Zimmeranzahl;
    }

    public int getJahr() {
        return this.Baujahr;
    }

    public int getPLZ() {
        return PLZ;
    }
    public int getEtagen(){
        return Stockwerk;
    }

    public String getStrasse() {
        return Strasse;
    }

    public int getHausnummer() {
        return Hausnummer;
    }

    public int getTop() {
        return Top;
    }
}
