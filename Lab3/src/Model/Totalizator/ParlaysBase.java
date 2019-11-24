package Model.Totalizator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParlaysBase {

    private Map<String, ArrayList<Parlay>> parlays;

    public ParlaysBase() {
        this.parlays = new HashMap<String, ArrayList<Parlay>>();
    }

    public Map<String, ArrayList<Parlay>> getParlays() {
        return this.parlays;
    }

    public ArrayList<Parlay> getParlaysByUser(String username) {
        ArrayList<Parlay> parlays = this.parlays.get(username);

        if (parlays == null) {
            return new ArrayList<Parlay>();
        } else {
            return  parlays;
        }
    }

    public void clearParlays() {
        this.parlays.clear();
    }

    public void addParlay(String username, Parlay parlay) {
        if (this.parlays.containsKey(username)) {
            this.parlays.get(username).add(parlay);
        } else {
            ArrayList<Parlay> parlaysList  = new ArrayList<Parlay>();
            parlaysList.add(parlay);
            this.parlays.put(username, parlaysList);
        }

    }

}
