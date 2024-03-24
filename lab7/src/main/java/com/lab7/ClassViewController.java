package com.lab7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ClassViewController {
    @FXML
    private TextArea studentInfo;
    @FXML
    private TableView<Degree> degreeList;
    @FXML
    private TableColumn<Object, Object> comment;
    @FXML
    private TableColumn<Object, Object> degree;
    @FXML
    private Button backButton;
    @FXML
    private Button resignButton;
    @FXML
    private Button changeInfoButton;
    public static Student classViewStudent;

    public void initialize() {
        setInfoText();
        ObservableList<Degree> content = FXCollections.observableArrayList(classViewStudent.degrees);
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        degreeList.setItems(content);
    }

    private void setInfoText() {
        String info = String.format("%s %s\n%s\nStudent status: %s\nMean: %s",
                classViewStudent.getName(),
                classViewStudent.getSurname(),
                classViewStudent.getSubject(),
                classViewStudent.studentCondition,
                classViewStudent.getMeanString()
        );
        studentInfo.setText(info);
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400 , 600);
        StudentApplication.stg.setScene(scene);
    }

    public void onResignButtonClick() {
        classViewStudent.setStudentCondition(StudentCondition.REMOVED);
        setInfoText();
    }

    public void onChangeInfoButtonClick() {
        if (classViewStudent.studentCondition == StudentCondition.PRESENT) {
            classViewStudent.studentCondition = StudentCondition.ABSENT;
        }
        else if (classViewStudent.studentCondition != StudentCondition.REMOVED) {
            classViewStudent.studentCondition = StudentCondition.PRESENT;
        }
        setInfoText();
    }
}
