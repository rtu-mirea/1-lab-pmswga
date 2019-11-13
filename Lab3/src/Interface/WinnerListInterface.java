package Interface;

import Totalizator.Horse;
import Totalizator.Parlay;
import Users.User;

import java.util.ArrayList;
import java.util.Map;

public class WinnerListInterface {

    private Map<User, Double> winners;

    public WinnerListInterface(Map<User, Double> winners) {
        this.winners = winners;
    }

    public void view() {
        int id = 1;

        System.out.println("+[id]+--[User]--+--[Sum]--+");
        for (User user : this.winners.keySet()) {
            System.out.print("|");
            System.out.format("%-4s", id);
            System.out.print("|");
            System.out.format("%-10s", user.getLogin());
            System.out.print("|");
            System.out.format("%-9s", this.winners.get(user));
            System.out.print("|");

            System.out.println("");

            id++;
        }

        System.out.println("+----+-----------+");
    }

}
