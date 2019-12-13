package Forms;

import Model.Totalizator.Horse;
import Model.TotalizatorSingleton;

import javax.swing.*;

public class AddHorseForm extends JFrame {

    private JLabel horseNameLabel;

    private JTextField horseNameField;

    private JButton cancelButton;
    private JButton addButton;

    public AddHorseForm() {
        setSize(350, 100);
        setResizable(false);

        Box horseNameBox = Box.createHorizontalBox();
        horseNameLabel = new JLabel("Имя лошади:");
        horseNameField = new JTextField();

        horseNameBox.add(horseNameLabel);
        horseNameBox.add(horseNameField);

        Box buttonBox = Box.createHorizontalBox();
        cancelButton = new JButton("Отмена");
        addButton = new JButton("Добавить");
        addButton.addActionListener(e -> {
            TotalizatorSingleton.get().getHorseBase().addHorse(new Horse(horseNameField.getText()));
        });

        buttonBox.add(cancelButton);
        buttonBox.add(addButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(horseNameBox);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
    }

}
