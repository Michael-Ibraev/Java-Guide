package com.example.javaguide;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;

public class Compiler {
    @FXML
    TextArea Input;
    @FXML
    TextArea Output;

    public void compile(){
        String output ="";
        String code = Input.getText();
        File file = new File("HelloWorld.java");
        System.out.println(code);
        Output.setText(output);
    }

}
