package Interface;

import Users.User;
import Users.UsersBase;

public class UserListInterface {

    private UsersBase usersBase;

    public UserListInterface(UsersBase usersBase) {
        this.usersBase = usersBase;
    }

    public void view() {
        int id = 1;

        System.out.println("+[id]+--[Name]--+--[Login]--+");

        for (User user : this.usersBase.getUsers()) {
            System.out.print("|");
            System.out.format("%-4s", Integer.toString(id));
            System.out.print("|");
            System.out.format("%-10s", user.getName());
            System.out.print("|");
            System.out.format("%-11s", user.getLogin());
            System.out.print("|");

            System.out.println("");

            id++;
        }

        System.out.println("+----+----------+-----------+");
    }

}
