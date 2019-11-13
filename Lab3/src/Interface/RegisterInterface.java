package Interface;

import Users.User;
import Users.UserType;

import java.util.Scanner;

public class RegisterInterface {

    private User user;
    private String name;
    private String login;
    private String password;
    private UserType type;

    public RegisterInterface() {
        this.user     = null;
        this.name     = "";
        this.login    = "";
        this.password = "";
        this.type     = UserType.USER_CLIENT;
    }

    public User getRegisteredUser() {
        if (this.user == null) {
            return new User(this.name, this.login, this.password, this.type);
        }

        return this.user;
    }

    public void view() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        while (this.name.isEmpty()) {
            this.name = input.nextLine();
        }

        System.out.print("Enter login: ");
        while (this.login.isEmpty()) {
            this.login = input.nextLine();
        }

        System.out.print("Enter password: ");
        while (this.password.isEmpty()) {
            this.password = input.nextLine();
        }

        //input.close();
    }

}
