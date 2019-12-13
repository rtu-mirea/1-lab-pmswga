package Controllers;

import Forms.AdminForm;
import Forms.LoginForm;
import Model.Totalizator.Totalizator;
import Model.TotalizatorSingleton;
import Forms.MainForm;
import Forms.RegisterForm;
import Model.Users.User;
import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FormController  implements ActionListener {

    private String formName;
    private Object form;

    private RegisterForm registerForm;
    private MainForm mainForm;
    private AdminForm adminForm;

    public FormController(String formName, Object form) {
        this.formName = formName;
        this.form = form;

        this.registerForm = new RegisterForm();
        this.mainForm = new MainForm();
        this.adminForm = new AdminForm();
    }

    public void checkLogin() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (this.formName) {
            case "RegForm":
            {
                registerForm.setVisible(true);
            } break;
            case "MainForm":
            {
                String login = ((LoginForm) form).getLoginField().getText();
                String pass = ((LoginForm) form).getPassField().getText();

                if (login.equals("admin") && pass.equals("admin")) {
                    TotalizatorSingleton.get().getUsersBase().getUser("admin");
                    adminForm.setVisible(true);
                } else {
                    User user = TotalizatorSingleton.get().getUsersBase().getUser(login);
                    if (user != null) {
                        TotalizatorSingleton.setCurrentUser(user);
                        mainForm.setVisible(true);
                    }
                }
            } break;
        }
    }
}
