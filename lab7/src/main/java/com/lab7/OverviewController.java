package com.lab7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class OverviewController {
    @FXML
    private TextArea studentInfo;
    @FXML
    private TableView<Student> subjectList;
    @FXML
    private TableColumn<Object, Object> className;
    @FXML
    private TableColumn<Object, Object> degree;
    @FXML
    private TextField filterField;
    @FXML
    private Button openClassButton;
    @FXML
    private Button findClassButton;
    public static Student overviewStudent;
    ObservableList<Student> content;

    public void initialize() {
        if (StudentApplication.school == null) {
            try {
//                ReadWrite.readFromFileCSV();
                ReadWrite.readFromFileSerialization();
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incomplete data");
                alert.setHeaderText("Missing data!");
                alert.setContentText("Data is incomplete - provide proper file.");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }
        }
        String info = String.format("%s %s", overviewStudent.getName(), overviewStudent.getSurname());
        studentInfo.setText(info);
        ArrayList<Student> classes = StudentApplication.school.findClasses(overviewStudent);
        subjectList.setRowFactory(tableView -> {
            final TableRow<Student> row = new TableRow<>();
            row.hoverProperty().addListener((observable) -> {
                Tooltip tip = new Tooltip();
                final Student student = row.getItem();
                if (row.isHover() && student != null) {
                    tip.setText(student.tooltipInfo());
                    subjectList.setTooltip(tip);
                }
            });
            return row;
        });
        content = FXCollections.observableArrayList(classes);
        className.setCellValueFactory(new PropertyValueFactory<>("subject"));
        degree.setCellValueFactory(new PropertyValueFactory<>("meanString"));
        FilteredList<Student> filteredContent = new FilteredList<>(content, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredContent.setPredicate(student -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (student.getSubject().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                try {
                    if (student.getMean() >= Double.parseDouble(lowerCaseFilter)) {
                        return true;
                    }
                } catch (NumberFormatException nfe) {
                    return false;
                }
                return false;
            });
        });
        SortedList<Student> sortedContent = new SortedList<>(filteredContent);
        sortedContent.comparatorProperty().bind(subjectList.comparatorProperty());
        subjectList.setItems(sortedContent);
    }
    public void onOpenClassButtonClick() throws IOException {
        ClassViewController.classViewStudent = subjectList.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("class-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400 , 600);
        StudentApplication.stg.setScene(scene);
    }
    public void onFindClassButtonClick() throws IOException {
        FindClassController.findClassStudent = overviewStudent;
        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("find-class.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400 , 600);
        StudentApplication.stg.setScene(scene);
    }
}
