package Interface;

import Totalizator.Totalizator;
import Totalizator.Horse;

public class AboutRaceInterface {

    private Totalizator totalizator;

    public AboutRaceInterface(Totalizator totalizator) {
        this.totalizator = totalizator;
    }

    public void view() {
        System.out.println("Play coefficient: " + totalizator.getCoefficient());
        System.out.println("Horses table:");

        int id = 1;
        if (!totalizator.getHorseBase().getHorses().isEmpty()) {
            System.out.println("+[id]+--[Horse]--+");

            for (Horse parlay : totalizator.getHorseBase().getHorses()) {

                System.out.print("|");
                System.out.format("%-4s", id);
                System.out.print("|");
                System.out.format("%-11s", parlay.getName());
                System.out.print("|");
                System.out.println();

                id++;
            }

            System.out.println("+----+-----------+");
        } else {
            System.out.print("Horses list is empty");
        }
    }

}
