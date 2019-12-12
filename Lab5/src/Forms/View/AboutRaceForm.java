package Forms.View;

import javax.swing.*;

public class AboutRaceForm extends JFrame {

    JLabel playCoefficientLabel;
    JTextField playCoefficientField;

    JTable horseTable;

    public AboutRaceForm() {
        setTitle("Информация о забеге");
        setSize(640, 480);

        Box playCoefficientBox = Box.createHorizontalBox();
        playCoefficientLabel = new JLabel();
        playCoefficientField = new JTextField();

        playCoefficientBox.add(playCoefficientLabel);
        playCoefficientBox.add(playCoefficientField);

        JPanel horseTablePanel = new JPanel();
        horseTablePanel.setBorder(BorderFactory.createTitledBorder("Список лошадей"));
        horseTable = new JTable(10, 2);

        horseTablePanel.add(horseTable);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(playCoefficientBox);
        mainBox.add(horseTablePanel);

        setContentPane(mainBox);
        setVisible(true);
    }

}
