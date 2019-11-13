package Interface;

import Totalizator.Horse;
import Users.User;

import java.util.ArrayList;

public class WinnerListInterface {

    private ArrayList<User> userList;

    public WinnerListInterface(ArrayList<User> userList) {
        this.userList = userList;
    }

    public void view() {
        int id = 1;
        System.out.println("+[id]+--[User]--+");

        for (User user : this.userList) {

            System.out.print("|");
            System.out.format("%-4s", id);
            System.out.print("|");
            System.out.format("%-11s", user.getLogin());
            System.out.print("|");

            System.out.println("");

            id++;
        }

        System.out.println("+----+-----------+");
    }

}
