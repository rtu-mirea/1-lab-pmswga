package Interface;

import Totalizator.Parlay;
import Totalizator.ParlaysBase;

import java.util.Scanner;

public class AddParlayInterface {

    private Parlay parlay;
    private String horse;
    private int sum;

    public AddParlayInterface() {
        this.parlay    = null;
        this.horse     = "";
        this.sum       = 0;
    }

    public Parlay getAddedParlay() {
        if (this.parlay == null) {
            return new Parlay(this.horse, this.sum);
        }

        return this.parlay;
    }

    public void view() {
        Scanner input = new Scanner(System.in);

        //TODO: Realize select horse from HorsesBase
        System.out.print("Enter horse name: ");
        while (this.horse.isEmpty()) {
            this.horse = input.nextLine();
        }

        System.out.print("Enter parlay sum: ");
        while (this.sum == 0) {
            this.sum = input.nextInt();
        }
    }

}
