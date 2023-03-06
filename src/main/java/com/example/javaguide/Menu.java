package com.example.javaguide;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    public void toChapters() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("chapters.fxml"));
        // stage.getIcons().add(new Image(""));
        stage.setTitle("Теория");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.setResizable(false);
    }

    public void toCompiler() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("compiler.fxml"));
        // stage.getIcons().add(new Image(""));
        stage.setTitle("Компилятор");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
        stage.setResizable(false);
    }
}
