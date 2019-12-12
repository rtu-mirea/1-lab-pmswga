package Forms;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class AddParlayForm extends JFrame {

    JTable parlayTable;

    JLabel parlaySumLabel;

    JSpinner parlaySumSpinner;

    private JButton cancelButton;
    private JButton addButton;

    public AddParlayForm() {
        setTitle("Добавить ставку");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel horseTablePanel = new JPanel();
        parlayTable = new JTable(10, 2);
        parlayTable.addColumn(new TableColumn(0, 10));
        parlayTable.setSize(horseTablePanel.getSize());

        horseTablePanel.setBorder(BorderFactory.createTitledBorder("Список лошадей"));
        horseTablePanel.add(parlayTable);

        Box parlaySumBox = Box.createHorizontalBox();
        parlaySumLabel = new JLabel("Сумма ставки:");
        parlaySumSpinner = new JSpinner();

        parlaySumBox.add(parlaySumLabel);
        parlaySumBox.add(parlaySumSpinner);

        Box buttonBox = Box.createHorizontalBox();
        cancelButton = new JButton("Отмена");
        addButton = new JButton("Добавить");

        buttonBox.add(cancelButton);
        buttonBox.add(addButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(horseTablePanel);
        mainBox.add(parlaySumBox);

        setContentPane(mainBox);
        setVisible(true);
    }

}
