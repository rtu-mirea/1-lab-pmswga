package Forms.TableModel;

import javax.swing.table.AbstractTableModel;

public class HorseTableModel extends AbstractTableModel {

    String []columns;
    String [][]array;

    public HorseTableModel(String [][]array, String []columns) {
        this.array = array;
        this.columns = columns;
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