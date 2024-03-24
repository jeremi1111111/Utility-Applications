import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Logbook {
    private JTable table1;
    private JPanel panel1;
    private JButton menuOpenButton;
    private JButton addButton;
    private JButton sortButton;
    private JButton removeButton;
    private JButton changeInfoButton;
    private JTextField textField1;
    private ClassContainer classes;
    private myTableModel<ClassContainer> classContainerMyTableModel;
    private myTableModel<Class> classMyTableModel;
    private Object tableSelection;

    public Logbook() {
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                tableSelection = table1.getValueAt(row, col);
            }
        });
        menuOpenButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table1.getModel().equals(classContainerMyTableModel)) {
                    classMyTableModel = new myTableModel<>(classes.getGroup((String) tableSelection));
                    table1.setModel(classMyTableModel);
                    menuOpenButton.setText("Menu");
                }
                else {
                    table1.setModel(classContainerMyTableModel);
                    menuOpenButton.setText("Open Class");
                    classMyTableModel = null;
                }
                tableSelection = null;
                textField1.setText("");
            }
        });
        sortButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
                table1.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
                if (table1.getModel().equals(classMyTableModel)) {
                    sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
                }
                else if (table1.getModel().equals(classContainerMyTableModel)) {
                    sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
                }
                sorter.setSortKeys(sortKeys);
            }
        });
        removeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table1.getModel().equals(classMyTableModel)) {
                    int rowIndex = table1.getSelectedRow();
                    Student student = classMyTableModel.data.studentsList.get(rowIndex);
                    Class group = classMyTableModel.data;
                    group.getStudent(student);
                    classMyTableModel = new myTableModel<>(group);
                    table1.setModel(classMyTableModel);
                }
                else if (table1.getModel().equals(classContainerMyTableModel)) {
                    String name = (String) table1.getValueAt(table1.getSelectedRow(), table1.getSelectedColumn());
                    classes.removeClass(name);
                    classContainerMyTableModel = new myTableModel<>(classes);
                    table1.setModel(classContainerMyTableModel);
                }
            }
        });
        changeInfoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tableSelection == null) return;
                int row = table1.getSelectedRow();
                if (table1.getModel().equals(classMyTableModel)) {
                    Student student = classMyTableModel.data.studentsList.get(row);
                    student.name = JOptionPane.showInputDialog("Name", student.name);
                    student.surname = JOptionPane.showInputDialog("Surname", student.surname);
                    student.yearOfBirth = Integer.parseInt(JOptionPane.showInputDialog("Year of birth", student.yearOfBirth));
                    classMyTableModel = new myTableModel<>(classMyTableModel.data);
                    table1.setModel(classMyTableModel);
                }
                else if (table1.getModel().equals(classContainerMyTableModel)) {
                    Class group = classContainerMyTableModel.data.getGroup((String) table1.getValueAt(row, 0));
                    classContainerMyTableModel.data.groups.remove(group.className);
                    group.className = JOptionPane.showInputDialog("Group name", group.className);
                    group.capacity = Integer.parseInt(JOptionPane.showInputDialog("Capacity", group.capacity));
                    classContainerMyTableModel.data.groups.put(group.className, group);
                    classContainerMyTableModel = new myTableModel<>(classContainerMyTableModel.data);
                    table1.setModel(classContainerMyTableModel);
                }
            }
        });
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table1.getModel().equals(classMyTableModel)) {
                    String name = JOptionPane.showInputDialog("Name");
                    String surname = JOptionPane.showInputDialog("Surname");
                    String yearOfBirth = JOptionPane.showInputDialog("Year of birth");
                    Student student = new Student(name, surname, StudentCondition.ABSENT, Integer.parseInt(yearOfBirth), 0);
                    classMyTableModel.data.addStudent(student);
                    classMyTableModel = new myTableModel<>(classMyTableModel.data);
                    table1.setModel(classMyTableModel);
                }
                else if (table1.getModel().equals(classContainerMyTableModel)) {
                    String name = JOptionPane.showInputDialog("Group name");
                    String capacity = JOptionPane.showInputDialog("Capacity");
                    classContainerMyTableModel.data.addClass(name, Integer.parseInt(capacity));
                    classContainerMyTableModel = new myTableModel<>(classContainerMyTableModel.data);
                    table1.setModel(classContainerMyTableModel);
                }

            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
                    table1.setRowSorter(sorter);
                    RowFilter<TableModel, Object> rf = null;
                    //If current expression doesn't parse, don't update.
                    try {
                        rf = RowFilter.regexFilter(textField1.getText(), 0);
                    } catch (java.util.regex.PatternSyntaxException ex) {
                        return;
                    }
                    sorter.setRowFilter(rf);
                }
            }
        });
    }

    public void createData() {
        classes = new ClassContainer();
        classes.addClass("Class 1", 15);
        classes.addClass("Class 2", 20);
        classes.addClass("Class 3", 5);
        Student s1 = new Student("Jan", "Kowalski", StudentCondition.SICK, 2001, 0);
        classes.addToClass("Class 1", s1);
        for (int i = 0; i < 10; i++) {
            Student s2 = new Student("Krzysztof", "Nowak", StudentCondition.CATCHING_UP, 2000, i);
            Student s3 = new Student("Szymon", "Zajac", StudentCondition.ABSENT, 1999, i + 10);
            classes.addToClass("Class 2", s2);
            classes.addToClass("Class 2", s3);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Logbook");
        frame.setContentPane(new Logbook().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        createData();
        classContainerMyTableModel = new myTableModel<>(classes);
        table1 = new JTable(classContainerMyTableModel);
    }
}
