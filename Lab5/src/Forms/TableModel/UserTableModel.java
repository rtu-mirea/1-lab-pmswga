package Forms.TableModel;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

    private String []columns;
    private String [][]array;

    public UserTableModel(String [][]array, String []columns) {
        this.columns = columns;
        this.array = array;
    }

    @Override
    public int getRowCount() {
        return array.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return array[rowIndex][columnIndex];
    }
}