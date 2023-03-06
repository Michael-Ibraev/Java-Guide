package com.example.javaguide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteChapter {
    @FXML
    private Button cancel;
    public static int id;
    //Метод для подтверждения удаления раздела
    public void submit(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection(DB.DATABASE_URL, DB.DATABASE_USERNAME, DB.DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("delete from java_guide.chapters where chapter_id ="+id);
        preparedStatement.execute();
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    //Метод отмены удаления раздела
    public void cancel(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
