package Controller;

import java.util.Scanner;

public class SetCoefficientController {

    private Integer coefficient;

    public SetCoefficientController() {
        this.coefficient = 0;
    }

    public Integer getCoefficient() {
        return this.coefficient;
    }

    public void view() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter play coefficient: ");
        while (this.coefficient <= 0 || this.coefficient > 100) {
            this.coefficient = input.nextInt();
        }

    }

}
