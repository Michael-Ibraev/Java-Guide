package com.example.javaguide;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AddChapter {
    @FXML
    private TextField nameField;
    //Метод добавления нового раздела
    public void add() throws SQLException {
        String name = nameField.getText();
        Connection connection = DriverManager.getConnection(DB.DATABASE_URL, DB.DATABASE_USERNAME, DB.DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into java_guide.chapters(chapter_name) values('"+name+"')");
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }
}
