import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

    MyTableModel(Object[][] tableData, Object[] colNames) {
        super(tableData, colNames);
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }
}