/**
 * @author Finn Mueller
 * @id 11934549
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hausverwaltung {
    private final HausverwaltungDAO hausverwaltungDAO;

    public Hausverwaltung(String dateiname) {
        this.hausverwaltungDAO = new HausverwaltungSerializationDAO(dateiname);
    }

    public void delete(int id) {
        this.hausverwaltungDAO.deleteWohnung(id);
    }

    public void add(Wohnung wohnung) {
        this.hausverwaltungDAO.saveWohnung(wohnung);
    }

    public int count(String type) {
        int counter = 0;
        List<Wohnung> l = this.hausverwaltungDAO.getWohnungen();
        for (Wohnung w : l) {
            if (w instanceof MietWohnung && type.equals("MW")) {
                ++counter;
            }

            if (w instanceof EigentumsWohnung && type.equals("EW")) {
                ++counter;
            }
        }
        return counter;
    }
    public int count(){
        return hausverwaltungDAO.getWohnungen().size();
    }

    public Double meancosts() {
        List<Wohnung> l = this.hausverwaltungDAO.getWohnungen();
        double mean = 0.0D;

        for (Wohnung wohnung : l) {
            mean = mean + wohnung.gesamtKosten();
        }

        return mean / (double)l.size();
    }

    List<Integer> oldest() {
        Wohnung highest = hausverwaltungDAO.getWohnungen()
                .stream()
                .max(Comparator.comparing(Wohnung::alter))
                .orElse(null);
        List<Wohnung> i= this.hausverwaltungDAO.getWohnungen()
                .stream()
                .filter(t -> {
                    assert highest != null;
                    return t.alter() == highest.alter();
                })
                .collect(Collectors.toList());
        List<Integer> o = new ArrayList<>();
        for(Wohnung k : i){
            o.add(k.getId());
        }
        return o;
    }

    void printAll() {
        List<Wohnung> l = this.hausverwaltungDAO.getWohnungen();
        for (Wohnung wohnung : l) {
            if (wohnung != null) {
                System.out.println(wohnung);
            }
        }
    }

    void printById(int id) {
        if(this.hausverwaltungDAO.getWohnungbyId(id) != null){
            System.out.println(this.hausverwaltungDAO.getWohnungbyId(id));
        }
    }
}
