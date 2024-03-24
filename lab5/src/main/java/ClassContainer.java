import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ClassContainer {
    public Map<String, Class> groups;

    public ClassContainer() {
        this.groups = new TreeMap<>();
    }

    public void addClass(String name, int capacity) {
        Class group = new Class(name, new ArrayList<Student>(), capacity);
        groups.put(name, group);
    }

    public void removeClass(String name) {
        groups.remove(name);
    }

    public ArrayList<Class> findEmpty() {
        ArrayList<Class> empty = new ArrayList<Class>();
        for (Class group : groups.values()) {
            if (group.getOccupancy() == 0) empty.add(group);
        }
        return empty;
    }

    public void summary() {
        System.out.println("Classes:");
        for (Map.Entry<String, Class> groupEntry : groups.entrySet()) {
            Class group = groupEntry.getValue();
            System.out.printf("%s : %d%% occupancy\n", groupEntry.getKey(), group.getOccupancy());
        }
    }

    public void addToClass(String className, Student student) {
        this.groups.get(className).addStudent(student);
    }

    public Class getGroup(String className) {
        return this.groups.get(className);
    }

    public void classSummary(String className) {
        this.groups.get(className).summary();
    }

    public void searchClassPartial(String className, String part) {
        ArrayList<Student> copy = this.groups.get(className).searchPartial(part);
        if (!copy.isEmpty()) System.out.printf("Students found for \"%s\" in %s:\n", part, className);
        for (Student student : copy) {
            System.out.println(student.toString());
        }
    }
}
