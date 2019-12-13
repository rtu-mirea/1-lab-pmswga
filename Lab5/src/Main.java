import Forms.*;
import Model.TotalizatorSingleton;

public class Main {

    static public void main(String []args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);

        System.out.println(TotalizatorSingleton.get().getUsersBase().getUsers().size());
    }

}
