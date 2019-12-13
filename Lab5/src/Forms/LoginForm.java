package Forms;
import Model.Totalizator.Totalizator;
import Model.Users.User;

import javax.swing.*;
import Controllers.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginForm extends JFrame {

    static private Totalizator totalizator = new Totalizator();
    static private User currentUser = null;

    private JLabel loginLabel;
    private JLabel passLabel;

    private JTextField loginField;
    private JTextField passField;

    private JButton exitButton;
    private JButton registerButton;
    private JButton loginButton;

    public LoginForm() {
        this.setTitle("Вход в систему");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(350, 100);

        Box loginBox = Box.createHorizontalBox();
        loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);

        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(12));
        loginBox.add(loginField);


        Box passBox = Box.createHorizontalBox();
        passLabel = new JLabel("Пароль:");
        passField = new JPasswordField(15);

        passBox.add(passLabel);
        passBox.add(Box.createHorizontalStrut(12));
        passBox.add(passField);

        exitButton = new JButton("Выход");
        exitButton.addActionListener(e -> System.exit(0));

        registerButton = new JButton("Регистрация");
        registerButton.addActionListener(new FormController("RegForm", this));

        loginButton = new JButton("Войти");
        loginButton.addActionListener(new FormController("MainForm", this));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(exitButton);
        buttonBox.add(registerButton);
        buttonBox.add(loginButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(loginBox);
        mainBox.add(passBox);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
    }


    public JTextField getLoginField() {
        return this.loginField;
    }

    public JTextField getPassField() {
        return passField;
    }
}
