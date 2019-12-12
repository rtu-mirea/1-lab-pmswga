package Forms;

import javax.swing.*;

public class AddHorseForm extends JFrame {

    private JLabel horseNameLabel;

    private JTextField horseNameField;

    private JButton cancelButton;
    private JButton addButton;

    public AddHorseForm() {

        Box horseNameBox = Box.createHorizontalBox();
        horseNameLabel = new JLabel("Имя лошади:");
        horseNameField = new JTextField();

        horseNameBox.add(horseNameLabel);
        horseNameBox.add(horseNameField);

        Box buttonBox = Box.createHorizontalBox();
        cancelButton = new JButton("Отмена");
        addButton = new JButton("Добавить");

        buttonBox.add(cancelButton);
        buttonBox.add(addButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(horseNameBox);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
        setVisible(true);
    }

}
