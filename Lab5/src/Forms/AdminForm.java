package Forms;
import Forms.TableModel.UserTableModel;
import Forms.TableModel.HorseTableModel;
import Model.TotalizatorSingleton;

import javax.swing.*;
import javax.swing.table.TableModel;


public class AdminForm extends JFrame {

    AddHorseForm addHorseForm;

    JTable userTable;
    JTable horseTable;

    JButton refreshUserTableButton;
    JButton refreshHorseTableButton;
    JButton addHorseButton;

    public AdminForm() {
        setTitle("Панель администратора");
        setSize(640, 480);
        setResizable(false);

        addHorseForm = new AddHorseForm();

        JPanel userTablePanel = new JPanel();
        userTablePanel.setBorder(BorderFactory.createTitledBorder("Список пользователей"));

        String []userTablecolumns = {"Id", "Name", "Login", "Type"};
        userTable = new JTable(TotalizatorSingleton.get().getUsersBase().toStringArray(), userTablecolumns);
        userTablePanel.add(userTable);

        JPanel horseTablePanel = new JPanel();
        horseTablePanel.setBorder(BorderFactory.createTitledBorder("Список лошадей"));

        String []horseTablecolumns = {"Id", "Name"};
        horseTable = new JTable(TotalizatorSingleton.get().getHorseBase().toStringArray(), horseTablecolumns);
        horseTablePanel.add(horseTable);

        Box buttonBox = Box.createHorizontalBox();
        refreshUserTableButton = new JButton("Обновить таблицу пользователей");
        refreshUserTableButton.addActionListener(e -> {
            userTable.setModel(new UserTableModel(TotalizatorSingleton.get().getUsersBase().toStringArray(), userTablecolumns));
        });

        refreshHorseTableButton = new JButton("Обновить таблицу лошадей");
        refreshHorseTableButton.addActionListener(e -> {
            horseTable.setModel(new UserTableModel(TotalizatorSingleton.get().getHorseBase().toStringArray(), horseTablecolumns));
        });

        addHorseButton = new JButton("Добавить лошадь");
        addHorseButton.addActionListener(e -> {
            addHorseForm.setVisible(true);
        });

        buttonBox.add(refreshUserTableButton);
        buttonBox.add(refreshHorseTableButton);
        buttonBox.add(addHorseButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(buttonBox);
        mainBox.add(userTablePanel);
        mainBox.add(horseTablePanel);

        setContentPane(mainBox);
    }

}
