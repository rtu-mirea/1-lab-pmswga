package Model.Totalizator;

import java.util.ArrayList;

public class HorseBase {

    private ArrayList<Horse> horses;

    public HorseBase() {
        this.horses = new ArrayList<Horse>();
    }

    public int getCountHorses() {
        return this.horses.size();
    }

    public Horse getHorseById(int id) {
        return this.horses.get(id-1);
    }

    public Horse getHorseByName(String name) {
        for (Horse horse : this.horses) {
            if (horse.getName().equals(name)) {
                return horse;
            }
        }

        return new Horse("");
    }

    public ArrayList<Horse> getHorses() {
        return this.horses;
    }

    public void addHorse(Horse horse) {
        this.horses.add(horse);
    }

    public String[][] toStringArray() {
        String[][] array = new String[this.horses.size()][2];

        for (int i = 0; i < this.horses.size(); i++) {
            array[i][0] = Integer.toString(i+1);
            array[i][1] = this.horses.get(i).getName();
        }

        return array;
    }

}
