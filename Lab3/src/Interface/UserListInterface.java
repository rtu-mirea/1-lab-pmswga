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

        for (String key : this.usersBase.getUsers().keySet()) {
            User user = this.usersBase.getUser(key);
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
