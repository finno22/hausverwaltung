/**
 * @author Finn Mueller
 * @id 11934549
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HausverwaltungSerializationDAO implements HausverwaltungDAO {
    private final String dateiname;

    HausverwaltungSerializationDAO(String dateiname) {
        this.dateiname = dateiname;
    }

    @SuppressWarnings("unchecked")
    public List<Wohnung> getWohnungen() {
        List<Wohnung> wohnungliste = null;
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.dateiname));
            wohnungliste = (List<Wohnung>) reader.readObject();
            reader.close();
        } catch (Exception var3) {
            System.err.println("Deserialisierungsfehler: " + var3.getMessage());
        }

        return wohnungliste;
    }

    public Wohnung getWohnungbyId(int id) {
        List<Wohnung> w = this.getWohnungen();

        if(w == null){
            return null;
        }

        for (Wohnung wohnung : w) {
            if (wohnung.getId() == id) {
                return wohnung;
            }
        }

        return null;
    }

    public void saveWohnung(Wohnung wohnung) {
        try{
            if(wohnung == null || wohnung.getJahr() > 2021){
                return;
            }

            if (this.getWohnungbyId(wohnung.getId()) != null) {
                throw new IllegalArgumentException("Wohnung bereits vorhanden. (id=" + wohnung.getId() + ")");
            }

            else {
                List<Wohnung> wohnungliste = this.getWohnungen();

                if(wohnungliste == null){
                    wohnungliste = new ArrayList<>();
                }

                File file = new File(this.dateiname);
                if (file.exists()) {
                    file.delete();
                }
                wohnungliste.add(wohnung);
                try{
                    ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.dateiname, true));
                    writer.writeObject(wohnungliste);
                    writer.close();
                } catch (Exception e) {
                    System.err.println("Fehler bei Serialisierung: " + e.getMessage());
                    System.exit(1);
                }
                System.out.println("Info: Wohnung " + wohnung.getId() +" added.");
            }

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void deleteWohnung(int id) {
        try{
            if (this.getWohnungbyId(id) == null) {
                throw new IllegalArgumentException("Wohnung nicht vorhanden. (id=" + id + ")");
            }
            else{
                List<Wohnung> wohnungliste = this.getWohnungen();
                if(wohnungliste == null){
                    wohnungliste = new ArrayList<Wohnung>();
                }
                File file = new File(this.dateiname);
                if (file.exists()) {
                    file.delete();
                }
                wohnungliste.removeIf(w -> w.getId() == id);

                try{
                    ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.dateiname, true));
                    writer.writeObject(wohnungliste);
                    writer.close();
                }          catch (Exception e) {

                    System.err.println("Fehler bei Serialisierung: " + e.getMessage());
                    System.exit(1);
                }
                System.out.println("Info: Wohnung " + id +" deleted.");
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}