package com.example.javaguide;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class HelloController {

    @FXML
    PasswordField passwordField;
    @FXML
    TextField passwordFieldNotHidden;
    @FXML
    CheckBox passwordCheckBox;
    @FXML
    TextField loginField;
    @FXML
    Label label;


    public void visiblePass(ActionEvent event){
        if(passwordCheckBox.isSelected()){
            passwordFieldNotHidden.setText(passwordField.getText());
            passwordFieldNotHidden.setVisible(true);
            passwordField.setVisible(false);
            return;
        }
        passwordField.setText(passwordField.getText());
        passwordField.setVisible(true);
        passwordFieldNotHidden.setVisible(false);
    }
    public void login(ActionEvent event) throws SQLException, IOException {
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());

        if (passwordField.getText().isEmpty()){
            label.setText("Ввдите пароль");
        }
        if(loginField.getText().isEmpty()){
            label.setText("Введите логин");
        }

        String login = loginField.getText();
        String password = passwordField.getText();

        DB db = new DB();
        boolean flag = db.validate(login, password);

        if(!flag){
            label.setText("Неверный логин или пароль");
        }
        else{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            // stage.getIcons().add(new Image(""));
            stage.setTitle("Меню");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
            stage.setResizable(false);
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }
}