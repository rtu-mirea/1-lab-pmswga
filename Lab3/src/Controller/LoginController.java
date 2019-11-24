package Controller;

import java.util.Scanner;

public class LoginController {

    private String login;
    private String password;

    public LoginController() {
        this.login    = "";
        this.password = "";
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void view() {
        Scanner inputt = new Scanner(System.in);

        System.out.print("Enter login: ");
        while (this.login.isEmpty()) {
            this.login = inputt.nextLine();
        }

        System.out.print("Enter password: ");
        while (this.password.isEmpty()) {
            this.password = inputt.nextLine();
        }

        //inputt.close();
    }

}
