public class Student implements Comparable<Student> {
    String name;
    String surname;
    StudentCondition studentStatus;
    int yearOfBirth;
    double points;

    public Student(String name, String surname, StudentCondition studentStatus, int yearOfBirth, double points) {
        this.name = name;
        this.surname = surname;
        this.studentStatus = studentStatus;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentCondition getStudentStatus() {
        return studentStatus;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getPoints() {
        return points;
    }

    public void setStudentStatus(StudentCondition studentStatus) {
        this.studentStatus = studentStatus;
    }

    public void addPoints(double points) {
        this.points += points;
    }

    public void removePoints(double points) {
        this.points -= points;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentStatus=" + studentStatus +
                ", yearOfBirth=" + yearOfBirth +
                ", points=" + points +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return this.surname.compareTo(student.surname);
    }
}
