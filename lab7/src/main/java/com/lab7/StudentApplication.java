package com.lab7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface SaveAnnotation
{
    String name();
    int index();
}

public class StudentApplication extends Application {
    public static ClassContainer school;
    public static Stage stg;
    @Override
    public void start(Stage stage) {
        stg = stage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("overview.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setTitle("Logbook");
            stage.setScene(scene);
        } catch (IOException e) {
            System.exit(-1);
        }
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exit program");
        alert.setHeaderText("Save data?");
        alert.setContentText("Do you wish to save data?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.YES) {
            ReadWrite.saveToFileSerialization();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}