package com.example.typokopia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Random;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/typokopia/Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 440);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/TypoKopia_Logo.png")));
        stage.getIcons().add(icon);
        String[] titles = {
                "Typokopia: ¡A Escribir!",
                "Typokopia: No se que poner de titulo",
                "Typokopia: Maquina de palabras",
                "Typokopia: Sip, hay mucho texto",
                "Typokopia: ¿Seras el mas rápido?",
                "Typokopia: Dislexia esvuto aqui",
                "Typokopia: ABCDEFGHIJKLMNÑOPQRSTUVWXYZ",
                "Typokopia: ¡No utilizo tildes!"
        };

        Random random = new Random();
        String randomTitle = titles[random.nextInt(titles.length)];
        stage.setTitle(randomTitle);
        stage.setScene(scene);
        stage.show();
    }
}
