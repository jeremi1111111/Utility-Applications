module com.example.lab7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab7 to javafx.fxml;
    exports com.lab7;
}