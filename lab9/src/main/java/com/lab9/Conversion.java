package com.lab9;

import com.lab9.Student.Student;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.StringWriter;
import java.util.List;

public class Conversion {
    public static String studentsToCSV(List<Student> students) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        StringWriter writer = new StringWriter();
        ColumnPositionMappingStrategy<Student> mappingStrategy = new ColumnPositionMappingStrategy<Student>();
        mappingStrategy.setType(Student.class);
        mappingStrategy.setColumnMapping("studentId","firstName","lastName","subjectId");
        StatefulBeanToCsvBuilder<Student> builder = new StatefulBeanToCsvBuilder<Student>(writer);
        StatefulBeanToCsv<Student> beanWriter = builder.withMappingStrategy(mappingStrategy).build();
        beanWriter.write(students);
        return writer.toString();
    }
}
