package View;

import Model.Users.User;

import java.util.Map;

public class WinnerListView {

    private Map<User, Integer> winners;

    public WinnerListView(Map<User, Integer> winners) {
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

        System.out.println("+----+----------+---------+");
    }

}
