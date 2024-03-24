import javax.swing.table.AbstractTableModel;
import java.util.Map;

public class myTableModel<T> extends AbstractTableModel {
    public T data;
    public String tableName;
    public String[] colNames;
    public java.lang.Class<?>[] colTypes;

    @Override
    public int getRowCount() {
        int rowCount = 0;
        if (data instanceof ClassContainer classContainer) {
            rowCount = classContainer.groups.size();
        }
        else if (data instanceof Class group) {
            rowCount = group.studentsList.size();
        }
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public java.lang.Class<?> getColumnClass(int columnIndex) {
        return colTypes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = null;
        if (data instanceof ClassContainer classContainer) {;
            Object group = classContainer.groups.entrySet().toArray()[rowIndex];
            if (columnIndex == 0) {
                obj = ((Map.Entry<String, Class>) group).getKey();
            }
            else if (columnIndex == 1) {
                obj = ((Map.Entry<String, Class>) group).getValue().getOccupancy();
            }
        }
        else if (data instanceof Class group) {
            Student student = group.studentsList.get(rowIndex);
            if (columnIndex == 0) {
                obj = student.name;
            }
            else if (columnIndex == 1) {
                obj = student.surname;
            }
            else if (columnIndex == 2) {
                obj = student.studentStatus;
            }
            else if (columnIndex == 3) {
                obj = student.points;
            }
            else if (columnIndex == 4) {
                obj = student.yearOfBirth;
            }
        }
        return obj;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public myTableModel(T data) {
        this.data = data;
        if (data instanceof ClassContainer) {
            colNames = new String[]{"Class", "Occupancy [%]"};
            colTypes = new java.lang.Class[]{String.class, Integer.class};
        }
        else if (data instanceof Class) {
            colNames = new String[]{"Name", "Surname", "Student status", "Points", "Year of birth"};
            colTypes = new java.lang.Class[]{String.class, String.class, StudentCondition.class, Double.class, Integer.class};
        }
    }
}
