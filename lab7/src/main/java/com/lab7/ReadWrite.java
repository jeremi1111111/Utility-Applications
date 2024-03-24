package com.lab7;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class ReadWrite {
    public static void saveToFileSerialization() throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream("lab7/school.txt"); // change each of these paths if you download only lab7
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(StudentApplication.school);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static void readFromFileSerialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream("lab7/school.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        ClassContainer school = (ClassContainer) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        for (Subject subject : school.groups.values()) {
            for (Student student : subject.studentsList) {
                student.studentCondition = StudentCondition.WAITING_FOR_ASSIGNMENT;
                if (OverviewController.overviewStudent == null) {
                    OverviewController.overviewStudent = student;
                }
            }
        }
        StudentApplication.school = school;
    }

    static ArrayList<Field> createFields(Field[] initialFields) {
        ArrayList<Field> fields = new ArrayList<>();
        for (Field field : initialFields) {
            if (field.getAnnotation(SaveAnnotation.class) != null) {
                int index = 0;
                for (Field field1 : fields) {
                    if (field.getAnnotation(SaveAnnotation.class).index() > field1.getAnnotation(SaveAnnotation.class).index()) {
                        index++;
                    }
                }
                fields.add(index, field);
            }
        }
        return fields;
    }

    public static void saveToFileCSV() throws FileNotFoundException, IllegalAccessException {
        List<String> subjects = new ArrayList<>();
        ArrayList<Field> subjectFields = createFields(Subject.class.getDeclaredFields());
        subjects.add("Subject,Maximum capacity");
        List<String> students = new ArrayList<>();
        ArrayList<Field> studentsFields = createFields(Student.class.getDeclaredFields());
        students.add("Name,Surname,Subject,Year of birth");
        List<String> degrees = new ArrayList<>();
        ArrayList<Field> degreesFields = createFields(Degree.class.getDeclaredFields());
        degrees.add("Name,Surname,Subject,Comment,Degree");
        for (Subject subject : StudentApplication.school.groups.values()) {
            subjects.add(
                    (String) subjectFields.get(0).get(subject) + ',' +
                    subjectFields.get(1).get(subject)
            );
            for (Student student : subject.studentsList) {
                students.add(
                        (String) studentsFields.get(0).get(student) + ',' +
                        studentsFields.get(1).get(student) + ',' +
                        studentsFields.get(2).get(student) + ',' +
                        studentsFields.get(3).get(student)
                );
                for (Degree degree : student.degrees) {
                    degrees.add(
                            (String) degreesFields.get(0).get(degree) + ',' +
                            degreesFields.get(1).get(degree) + ',' +
                            degreesFields.get(2).get(degree) + ',' +
                            degreesFields.get(3).get(degree) + ',' +
                            degreesFields.get(4).get(degree)
                    );
                }
            }
        }
        File subjectsCSV = new File("lab7/subjects.csv");
        try (PrintWriter printWriter = new PrintWriter(subjectsCSV)) {
            subjects.forEach(printWriter::println);
        }
        File studentsCSV = new File("lab7/students.csv");
        try (PrintWriter printWriter = new PrintWriter(studentsCSV)) {
            students.forEach(printWriter::println);
        }
        File degreesCSV = new File("lab7/degrees.csv");
        try (PrintWriter printWriter = new PrintWriter(degreesCSV)) {
            degrees.forEach(printWriter::println);
        }
    }

    public static void readFromFileCSV() throws IOException {
        List<Degree> degrees = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("lab7/degrees.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> degree;
                degree = Arrays.asList(line.split(","));
                try {
                    degrees.add(new Degree(degree.get(0), degree.get(1), degree.get(2), degree.get(3), Double.parseDouble(degree.get(4))));
                } catch (NumberFormatException ignored) {}
            }
        }
        List<Student> students = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("lab7/students.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> student;
                student = Arrays.asList(line.split(","));
                ArrayList<Degree> studentDegrees = new ArrayList<>();
                for (Degree degree : degrees) {
                    if (degree.studentName.equals(student.get(0)) &&
                            degree.studentSurname.equals(student.get(1)) &&
                            degree.subject.equals(student.get(2))) {
                        studentDegrees.add(degree);
                    }
                }
                try {
                    students.add(new Student(student.get(0), student.get(1), student.get(2), StudentCondition.WAITING_FOR_ASSIGNMENT, Integer.parseInt(student.get(3)), studentDegrees));
                } catch (NumberFormatException ignored) {}
            }
        }
        ClassContainer school = getClassContainer();
        for (Student student : students) {
            school.groups.get(student.subject).addStudent(student);
        }
        StudentApplication.school = school;
        OverviewController.overviewStudent = students.get(0);
    }

    private static ClassContainer getClassContainer() throws IOException {
        ClassContainer school = new ClassContainer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("lab7/subjects.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> subject;
                subject = Arrays.asList(line.split(","));
                try {
                    school.addClass(subject.get(0), Integer.parseInt(subject.get(1)));
                } catch (NumberFormatException ignored) {}
            }
        }
        return school;
    }
}
