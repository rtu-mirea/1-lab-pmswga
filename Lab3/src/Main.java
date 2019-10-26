
import Users.*;
import Interface.*;

class Main {

    static UsersBase usersBase = new UsersBase();

    static public void fillUserList() {
        usersBase.addUser(new User("admin", "admin", "admin", UserType.USER_ADMIN));
        usersBase.addUser(new User("Sergey", "pmswga", "pass", UserType.USER_CLIENT));
        usersBase.addUser(new User("Ivan", "walkman", "pass1", UserType.USER_CLIENT));
        usersBase.addUser(new User("Aleen", "john wick", "pass2", UserType.USER_CLIENT));
        usersBase.addUser(new User("Yuri", "cool boy", "pass3", UserType.USER_CLIENT));
        usersBase.addUser(new User("Aleksandr", "man", "pass4", UserType.USER_CLIENT));
    }

    static public void main(String args[]) {
        Main.fillUserList();

        EnterInterface enterInterface = new EnterInterface();
        enterInterface.view();

        if (usersBase.enter(enterInterface.getLogin(), enterInterface.getPassword())) {
            User user = usersBase.getUser(enterInterface.getLogin());
            System.out.println("You are entered! Welcome, " + user.getName());
        } else {
            // TODO: Реализовать интерфейс вывода ошибок
            System.out.println("You are not entered!");
        }
    }

}
