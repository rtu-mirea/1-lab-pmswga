package Interface;

import Totalizator.Horse;
import java.util.ArrayList;

public class HorseListInterface {

    private ArrayList<Horse> horses;

    public HorseListInterface(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public void view() {
        int id = 1;

        if (!this.horses.isEmpty()) {
            System.out.println("+[id]+--[Horse]--+");

            for (Horse parlay : this.horses) {

                System.out.print("|");
                System.out.format("%-4s", id);
                System.out.print("|");
                System.out.format("%-11s", parlay.getName());
                System.out.print("|");

                System.out.println("");

                id++;
            }

            System.out.println("+----+----------+-----------+");
        } else {
            System.out.print("Horses list is empty");
        }
    }

}
