package Interface;

import Totalizator.Horse;
import Totalizator.HorseBase;
import Totalizator.Parlay;
import Totalizator.ParlaysBase;

import java.util.ArrayList;
import java.util.Scanner;

public class AddParlayInterface {

    private Parlay parlay;
    private ArrayList<Horse> horseList;
    private int horseId;
    private int sum;

    public AddParlayInterface(ArrayList<Horse> horseList) {
        this.parlay    = null;
        this.horseList = horseList;
        this.horseId   = 0;
        this.sum       = 0;
    }

    public Parlay getAddedParlay() {
        if (this.parlay == null) {
            return new Parlay(this.horseList.get(this.horseId-1).getName(), this.sum);
        }

        return this.parlay;
    }

    public void view() {
        Scanner input = new Scanner(System.in);

        //TODO: Realize select horse from HorsesBase

        int id = 1;
        System.out.println("+[id]+--[Horse]--+");

        for (Horse parlay : this.horseList) {

            System.out.print("|");
            System.out.format("%-4s", id);
            System.out.print("|");
            System.out.format("%-11s", parlay.getName());
            System.out.print("|");

            System.out.println("");

            id++;
        }

        System.out.println("+----+-----------+");

        System.out.print("Enter horse id: ");
        while (this.horseId <= 0 || this.horseId > this.horseList.size()) {
            this.horseId = input.nextInt();
        }

        System.out.print("Enter parlay sum: ");
        while (this.sum == 0) {
            this.sum = input.nextInt();
        }
    }

}
