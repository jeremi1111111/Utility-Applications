package com.lab7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class FindClassController {
    public static Student findClassStudent;
    @FXML
    private TableView<Subject> subjectList;
    @FXML
    private TableColumn<Object, Object> className;
    @FXML
    private TableColumn<Object, Object> capacity;
    @FXML
    private Button backButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField filterField;
    ObservableList<Subject> content;

    public void initialize() {
        ArrayList<Subject> classes = StudentApplication.school.findNewSubjects(findClassStudent);
        content = FXCollections.observableArrayList(classes);
        className.setCellValueFactory(new PropertyValueFactory<>("className"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("occupancy"));
        FilteredList<Subject> filteredContent = new FilteredList<>(content, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredContent.setPredicate(cls -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return cls.className.contains(lowerCaseFilter);
            });
        });
        SortedList<Subject> sortedContent = new SortedList<>(filteredContent);
        sortedContent.comparatorProperty().bind(subjectList.comparatorProperty());
        subjectList.setItems(sortedContent);
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400 , 600);
        StudentApplication.stg.setScene(scene);
    }

    public void onSignUpButtonClick() {
        Subject cls = subjectList.getSelectionModel().getSelectedItem();
        cls.addStudent(new Student(findClassStudent.name, findClassStudent.surname, cls.className, StudentCondition.ASSIGNED, findClassStudent.yearOfBirth, new ArrayList<>()));
        content.remove(cls);
    }
}
