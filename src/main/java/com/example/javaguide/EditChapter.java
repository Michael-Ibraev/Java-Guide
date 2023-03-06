package com.example.javaguide;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
public class EditChapter implements Initializable {
    @FXML
    private VBox vbox;
    @FXML
    private TextField searchField;
    @FXML
    private Button cancel;
    //Метод отображения разделов учебника для редактирования и удаления
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DB db = new DB();
        ArrayList<String> chapters = null;
        ArrayList<String> chaptersId = null;
        try {
            chapters = db.getChapters();
            chaptersId = db.getChapterId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < chapters.size(); i++) {
            HBox hBox = new HBox();
            Button editButton = new Button();
            Button deleteButton = new Button();
            editButton.setId(chaptersId.get(i));
            deleteButton.setId(chaptersId.get(i));
            hBox.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;" + "-fx-border-color: #333");
            Label label = new Label();
            label.setText(chapters.get(i));
            label.setStyle("-fx-font-size: 24px;");
            label.setPadding(new Insets(5,5,5,20));
            editButton.setText("Редактировать");
            deleteButton.setText("Удалить");
            hBox.getChildren().add(editButton);
            hBox.setSpacing(5);
            hBox.getChildren().add(deleteButton);
            hBox.getChildren().add(label);
            hBox.setAlignment(Pos.CENTER_LEFT);
            deleteButton.setLineSpacing(5);
            hBox.setPadding(new Insets(0,0,0,10));
            vbox.getChildren().add(hBox);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(15));
            editButton.setOnAction(event -> {
                try {
                    edit();
                    EditingChapter.id = Integer.parseInt(editButton.getId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            deleteButton.setOnAction(event -> {
                try {
                    delete();
                    DeleteChapter.id = Integer.parseInt(deleteButton.getId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
    //Метод для переход на окно редактирования раздела
    public EventHandler<ActionEvent> edit() throws SQLException, IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editingChapter.fxml")));
        stage.setTitle("Редактирование раздела");
        stage.setScene(new Scene(root, 700, 480));
        stage.setResizable(false);
        stage.show();
        return null;
    }
    //Метод для переход на окно подтверждения удаления раздела
    public EventHandler<ActionEvent> delete() throws SQLException, IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteChapter.fxml")));
        stage.setTitle("Удаление раздела");
        stage.setScene(new Scene(root, 300, 200));
        stage.setResizable(false);
        stage.show();
        return null;
    }
    //Метод поиска разделов учебника для редактирования и удаления
    public void search(){
        vbox.getChildren().clear();
        DB db = new DB();
        ArrayList<String> chapters = null;
        ArrayList<String> chaptersId = null;
        try {
            chapters = db.getChapters();
            chaptersId = db.getChapterId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < chapters.size(); i++) {
            HBox hBox = new HBox();
            Button editButton = new Button();
            Button deleteButton = new Button();
            editButton.setId(chaptersId.get(i));
            deleteButton.setId(chaptersId.get(i));
            hBox.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;" + "-fx-border-color: #333");
            Label label = new Label();
            label.setText(chapters.get(i));
            label.setStyle("-fx-font-size: 24px;");
            label.setPadding(new Insets(5,5,5,20));
            editButton.setText("Редактировать");
            deleteButton.setText("Удалить");
            hBox.getChildren().add(editButton);
            hBox.setSpacing(5);
            hBox.getChildren().add(deleteButton);
            hBox.getChildren().add(label);
            hBox.setAlignment(Pos.CENTER_LEFT);
            deleteButton.setLineSpacing(5);
            hBox.setPadding(new Insets(0,0,0,10));
            vbox.getChildren().add(hBox);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(15));
            editButton.setOnAction(event -> {
                try {
                    edit();
                    EditingChapter.id = Integer.parseInt(editButton.getId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            deleteButton.setOnAction(event -> {
                try {
                    delete();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
