module com.example.javaguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;


    opens com.example.javaguide to javafx.fxml;
    exports com.example.javaguide;
}