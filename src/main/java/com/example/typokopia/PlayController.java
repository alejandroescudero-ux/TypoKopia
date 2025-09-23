package com.example.typokopia;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Alert;


import java.io.IOException;
import java.util.Random;


public class PlayController {
    @FXML
    private Label randomLabel;

    @FXML
    private TextField textBox;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label countLabel;

    @FXML
    private Label bossLabel1;

    @FXML
    private Label bossLabel2;

    private final String[] palabras = {
            "teclado",
            "pantalla",
            "ventana",
            "planeta",
            "montaña",
            "estrella",
            "camino",
            "reloj",
            "escuela",
            "sonrisa",
            "aire",
            "fuego",
            "lluvia",
            "tiempo",
            "palabra",
            "coche",
            "amigo",
            "ciudad",
            "musica",
            "letra",
            "puente",
            "sendero",
            "bosque",
            "cuerpo",
            "nacion",
            "hermano",
            "barcos",
            "maestra",
            "leones",
            "correr",
            "viajes",
            "frutas",
            "pueblo",
            "llaves",
            "torres",
            "madera",
            "flores",
            "arena",
            "puerta",
            "tronco",
            "carpeta",
            "colina",
            "luz",
            "puerto",
            "nube",
            "rio",
            "mesa",
            "silla",
            "piedra",
            "pared",
            "lago",
            "barro",
            "puño",
            "lanza",
            "mina",
            "plaza",
            "cerro",
            "campo",
            "perro",
            "gato"
    };

    private final String[] disxelia = {
            "mucisa",
            "hemrano",
            "mardea",
            "froles",
            "anera",
            "esterlla",
            "canimo",
            "sorinsa",
            "esculea",
            "murciegalo"
    };

    private final String[] aibofobia = {
            "radar",
            "reconocer",
            "anilina",
            "arenera",
            "rotor",
            "aerea",
            "rayar",
            "salas",
            "seres",
            "orejero"
    };

    private final String[] Hipopotomonstroesquipedalofobia = {
            "bibliotecario",
            "extraordinario",
            "rapidamente",
            "circunstancia",
            "paralelepipedo",
            "subterraneo",
            "arquitectura",
            "diccionario",
            "hipopotamo",
            "programacion",
            "transcripcion"
    };

    private final String[] Invertidas = {
            "odaclet",
            "allatnap",
            "anatnev",
            "atenalp",
            "añatnom",
            "allertse",
            "onimac",
            "joler",
            "alucecse",
            "asirnos"
    };

    private final String[] score1 = {
            "Bien Hecho",
            "Nunca mejor escrito",
            "Como Shakespare",
            "Rapidin rapidin rapidin",
            "Excelente",
            "Buen Trabajo",
            "Sigue asi",
            "Muy bien hecho",
            "Exacto",
            "Buen ritmo",
            "Lo lograste",
            "Correcto"
    };

    private final String[] score2 = {
            "Incorrecto",
            "Equivocado",
            "Falla Mecanografica",
            "Horrografia",
            "Fallaste",
            "Erroneo",
            "Se te cruzaron las letras",
            "Casi lo logras",
            "Errorcito",
            "Sigue intentando",
            "No fue esta vez",
            "Fijate bien"
    };

    private final Random random = new Random();

    private String currentWord;

    private final String[][] jefes = {
            disxelia,
            Hipopotomonstroesquipedalofobia,
            aibofobia,
            Invertidas
    };

    private final String[] nombreJefes = {
            "disxelia",
            "Hipopotomonstroesquipedalofobia",
            "aibofobia",
            "Invertidas"
    };

    private void setRandomWord() {
        if (lvl % 10 == 0) {
            int boss = random.nextInt(jefes.length);
            String[] listaJefe = jefes[boss];
            currentWord = listaJefe[random.nextInt(listaJefe.length)];
            bossLabel1.setVisible(true);
            bossLabel2.setText(nombreJefes[boss]);
            bossLabel2.setVisible(true);
        }
        else {
            currentWord = palabras[random.nextInt(palabras.length)];
            bossLabel1.setVisible(false);
            bossLabel2.setVisible(false);
        }

        randomLabel.setText(currentWord);
    }

    private int lvl = 1;
    private int count = 20;
    private Timeline timeline;
    private int total = 0;


    @FXML
    public void mainMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/typokopia/Menu.fxml"));
            Scene menu = new Scene(fxmlLoader.load(), 820, 440);
            Stage stage = (Stage) randomLabel.getScene().getWindow();
            stage.setScene(menu);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkWord(){
        String fieldWord = textBox.getText();
        scoreLabel.setVisible(true);
        if (currentWord.equals(fieldWord)) {
            String scoreLabel1 = score1[random.nextInt(score1.length)];
            scoreLabel.setStyle("-fx-text-fill: green;");
            scoreLabel.setText(scoreLabel1);
            lvl ++;
            levelLabel.setText(String.valueOf(lvl));
            setRandomWord();
            textBox.clear();
            startCountdown();
            if (lvl == 51){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ganaste");
                alert.setHeaderText("¡Buen trabajo!");
                alert.showAndWait();
                alert.setContentText("Tiempo Total: " + (total));
                mainMenu();
            }
        }
        else {
            String scoreLabel2 = score2[random.nextInt(score2.length)];
            scoreLabel.setStyle("-fx-text-fill: red;");
            scoreLabel.setText(scoreLabel2);
            textBox.clear();
        }
    }


    public void startCountdown(){
        if (timeline != null) {
            timeline.stop();
        }

        count = Math.max(0, 20 - ((lvl - 1) / 5) * 2);
        countLabel.setText(String.valueOf(count));

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            count--;
            total ++;
            if (count >= 0) {
                countLabel.setText(String.valueOf(count));
            }

            if (count == 0) {
                timeline.stop();
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Perdiste");
                    alert.setHeaderText("¡Se acabó el tiempo!");
                    alert.setContentText("Palabras escritas: " + (lvl-1));
                    alert.showAndWait();
                    mainMenu();
                });
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void initialize() {
        scoreLabel.setVisible(false);
        bossLabel1.setVisible(false);
        bossLabel2.setVisible(false);
        setRandomWord();
        textBox.setOnAction(event -> checkWord());
        startCountdown();
    }


}

