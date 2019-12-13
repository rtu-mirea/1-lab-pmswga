package Forms.View;

import Model.Totalizator.Totalizator;
import Model.TotalizatorSingleton;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;



public class AboutRaceForm extends JFrame {

    JLabel playCoefficientLabel;
    JTextField playCoefficientField;

    JTable horseTable;

    public AboutRaceForm() {
        setTitle("Информация о забеге");
        setSize(640, 480);

        Box playCoefficientBox = Box.createHorizontalBox();
        playCoefficientLabel = new JLabel("Игровой коэффициент:");
        playCoefficientField = new JTextField();
        this.playCoefficientField.setText(TotalizatorSingleton.get().getCoefficient().toString());

        playCoefficientBox.add(playCoefficientLabel);
        playCoefficientBox.add(playCoefficientField);

        JPanel horseTablePanel = new JPanel();
        horseTablePanel.setBorder(BorderFactory.createTitledBorder("Список лошадей"));
        String []columns = {"Id", "Name"};
        horseTable = new JTable(TotalizatorSingleton.get().getHorseBase().toStringArray(), columns);

        horseTablePanel.add(horseTable);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(playCoefficientBox);
        mainBox.add(horseTablePanel);

        setContentPane(mainBox);
    }
}
