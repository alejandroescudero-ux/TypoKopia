package com.example.typokopia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {

    @FXML
    public void playButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/typokopia/Play.fxml"));
        Scene play = new Scene(fxmlLoader.load(), 820, 440);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(play);
        stage.show();
    }

    @FXML
    public void infoButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/typokopia/Info.fxml"));
        Scene info = new Scene(fxmlLoader.load(), 820, 440);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(info);
        stage.show();
    }

    @FXML
    private void quitButton() {
        System.exit(0);
    }
}

