package com.example.javaguide;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ResourceBundle;

public class EditingChapter {
    public static int id;
    @FXML
    private TextField nameField;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private WebView webView;
    //Метод редактирования названия раздела учебника
    public void submit() throws SQLException {
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(htmlEditor.getHtmlText());

//        String name = nameField.getText();
//        Connection connection = DriverManager.getConnection(DB.DATABASE_URL, DB.DATABASE_USERNAME, DB.DATABASE_PASSWORD);
//        PreparedStatement preparedStatement = connection.prepareStatement("update java_guide.chapters set chapter_name ='"+name+"' where chapter_id ="+id);
//        preparedStatement.execute();
    }





}
