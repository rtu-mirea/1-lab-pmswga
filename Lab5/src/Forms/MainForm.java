package Forms;

import javax.swing.*;
import Controllers.MainFormSwitcher;

public class MainForm extends JFrame {

    private JTable parlayTable;

    private JButton aboutRaceButton;
    private JButton addParlayForm;

    public MainForm() {
        setSize(640, 480);

        JPanel parlayPanel = new JPanel();
        parlayPanel.setBorder(BorderFactory.createTitledBorder("Ставки"));
        parlayTable = new JTable();

        Box buttonBox = Box.createHorizontalBox();
        aboutRaceButton = new JButton("О ставке");
        aboutRaceButton.addActionListener(new MainFormSwitcher("AboutRaceForm"));

        addParlayForm = new JButton("Добавить ставку");
        addParlayForm.addActionListener(new MainFormSwitcher("AddParlayForm"));

        buttonBox.add(aboutRaceButton);
        buttonBox.add(addParlayForm);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(buttonBox);

        setContentPane(mainBox);
    }

}
