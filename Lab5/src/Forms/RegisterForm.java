package Forms;

import javax.swing.*;

public class RegisterForm extends JFrame {

    private JLabel nameLabel;
    private JLabel loginLabel;
    private JLabel passLabel;

    private JTextField nameField;
    private JTextField loginField;
    private JPasswordField passField;

    private JButton registerButton;
    private JButton cancelButton;

    public RegisterForm() {
        setVisible(true);
        setSize(640, 480);
        setTitle("Регистрация пользователя");

        Box nameBox = Box.createHorizontalBox();
        nameLabel = new JLabel("Имя:");
        nameField = new JTextField();

        nameBox.add(nameLabel);
        nameBox.add(nameField);

        Box loginBox = Box.createHorizontalBox();
        loginLabel = new JLabel("Логин:");
        loginField = new JTextField();

        loginBox.add(loginLabel);
        loginBox.add(loginField);

        Box passBox = Box.createHorizontalBox();
        passLabel = new JLabel("Пароль:");
        passField = new JPasswordField();

        passBox.add(passLabel);
        passBox.add(passField);

        Box buttonBox = Box.createHorizontalBox();
        cancelButton = new JButton("Отмена");
        registerButton = new JButton("Зарегистрироваться");

        buttonBox.add(cancelButton);
        buttonBox.add(registerButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(nameBox);
        mainBox.add(loginBox);
        mainBox.add(passBox);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
    }

}
