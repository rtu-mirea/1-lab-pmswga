package Forms;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame {


    private Box mainBox;
    private Box loginBox;
    private Box passBox;
    private Box buttonBox;

    private JLabel loginLabel;
    private JLabel passLabel;

    private JTextField loginField;
    private JTextField passField;

    private JButton exitButton;
    private JButton loginButton;

    public LoginForm() {
        this.setTitle("Вход в систему");
        this.setResizable(false);

        loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);
        loginBox = Box.createHorizontalBox();
        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(12));
        loginBox.add(loginField);


        passLabel = new JLabel("Пароль:");
        passField = new JPasswordField(15);
        passBox = Box.createHorizontalBox();
        passBox.add(passLabel);
        passBox.add(Box.createHorizontalStrut(12));
        passBox.add(passField);

        exitButton = new JButton("Выход");
        exitButton.addActionListener(e -> System.exit(0));
        loginButton = new JButton("Войти");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().equals("admin") && passField.getText().equals("admin")) {
                    System.out.print("You are admin");
                }
            }
        });


        buttonBox = Box.createHorizontalBox();
        buttonBox.add(exitButton);
        buttonBox.add(loginButton);

        mainBox = Box.createVerticalBox();
        mainBox.add(loginBox);
        mainBox.add(passBox);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
        this.setVisible(true);
    }


}
