package Interface;

import Totalizator.Parlay;
import java.util.ArrayList;

public class ParlayListInterface {

    private ArrayList<Parlay> parlays;

    public ParlayListInterface(ArrayList<Parlay> parlays) {
        this.parlays = parlays;
    }

    public void view() {
        int id = 1;

        if (!this.parlays.isEmpty()) {
            System.out.println("+[id]+--[Horse]--+--[Sum]--+");

            for (Parlay parlay : this.parlays) {

                System.out.print("|");
                System.out.format("%-4s", Integer.toString(id));
                System.out.print("|");
                System.out.format("%-11s", parlay.getHorse());
                System.out.print("|");
                System.out.format("%-9s", parlay.getSum());
                System.out.print("|");

                System.out.println("");

                id++;
            }

            System.out.println("+----+----------+-----------+");
        } else {
            System.out.print("List parlays is empty");
        }
    }
}
