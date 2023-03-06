package com.example.javaguide;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class Chapters implements Initializable {
    @FXML
    private VBox vbox;
    @FXML
    private TextField searchField;
    //Отображение разделв учебника из БД
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DB db = new DB();
        ArrayList<String> chapters = null;
        try {
            chapters = db.getChapters();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < chapters.size(); i++) {
            VBox vBox = new VBox();
            vBox.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;" + "-fx-border-color: #333");
            Label label = new Label();
            label.setText(chapters.get(i));
            label.setStyle("-fx-font-size: 24px;");
            label.setPadding(new Insets(5,5,5,40));
            vBox.getChildren().add(label);
            vbox.getChildren().add(vBox);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(15));
        }
    }
    //Поиск разделов по ключевым словам
    public void search(){
        vbox.getChildren().clear();
        DB db = new DB();
        ArrayList<String> chapters = null;
        try {
            chapters = db.searchChapters(searchField.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < chapters.size(); i++) {
            VBox vBox = new VBox();
            vBox.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;" + "-fx-border-color: #333");
            Label label = new Label();
            label.setText(chapters.get(i));
            label.setStyle("-fx-font-size: 24px;");
            label.setPadding(new Insets(5,5,5,20));
            vBox.getChildren().add(label);
            vbox.getChildren().add(vBox);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(15));
        }
    }
    //Переход на окно добавления раздела
    public void addChapter() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addChapter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        stage.setTitle("Новый раздел");
        stage.setScene(scene);
        stage.show();
    }
    //Переход на окно редактирования
    public void editChapter() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editChapter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Редактировать раздел");
        stage.setScene(scene);
        stage.show();
    }
}

