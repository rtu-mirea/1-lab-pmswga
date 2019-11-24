package Controller;

import Model.Totalizator.Horse;

import java.util.Scanner;

public class AddHorseController {

    private Horse horse;
    private String name;

    public AddHorseController() {
        this.horse = null;
        this.name  = "";
    }

    public Horse getAddedHorse() {
        if (this.horse == null) {
            return new Horse(this.name);
        }

        return this.horse;
    }

    public void view() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter horse name: ");
        while (this.name.isEmpty()) {
            this.name = input.nextLine();
        }


    }

}
