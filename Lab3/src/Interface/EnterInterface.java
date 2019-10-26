package Interface;

import java.util.Scanner;

public class EnterInterface extends AbstractInterface {

    private String login;
    private String password;

    public EnterInterface() {
        this.login    = "";
        this.password = "";
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public void view() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter login: ");
        while (this.login.isEmpty()) {
            this.login = input.nextLine();
        }

        System.out.print("Enter password: ");
        while (this.password.isEmpty()) {
            this.password = input.nextLine();
        }

        input.close();
    }

}
