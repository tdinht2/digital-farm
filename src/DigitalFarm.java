import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;

public class DigitalFarm extends Application {

    private int difficulty = 0;
    private String playerName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Digital Farm");

        //Creating start menu with start button
        main.Player player = new main.Player();
        StackPane startMenu = new StackPane();
        Button btn = new Button();
        btn.setText("Start");
        btn.setMinSize(150, 30);
        Image image = new Image("Digital_Farm.png");
        ImageView iv = new ImageView(image);
        iv.fitWidthProperty().bind(primaryStage.widthProperty());
        iv.fitHeightProperty().bind(primaryStage.heightProperty());

        // Show start menu
        startMenu.getChildren().add(iv);
        startMenu.getChildren().add(btn);
        primaryStage.setScene(new Scene(startMenu, 1080, 720));
        primaryStage.show();



        //Create Initial Menu

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        HBox nameBox = new HBox(nameField);
        nameBox.setAlignment(Pos.CENTER);

        // Difficulty buttons / HBox
        Button easyBtn = new Button("Easy");
        Button mediumBtn = new Button("Medium");
        Button difficultBtn = new Button("Difficult");
        HBox difficultyBox = new HBox(5, easyBtn, mediumBtn, difficultBtn);
        difficultyBox.setAlignment(Pos.CENTER);

        // Starting seed buttons / HBox
        Button seed1Btn = new Button("seed1");
        Button seed2Btn = new Button("seed2");
        Button seed3Btn = new Button("seed3");
        HBox seedsBox = new HBox(5, seed1Btn, seed2Btn, seed3Btn);
        seedsBox.setAlignment(Pos.CENTER);

        // Starting season buttons / HBox
        Button springBtn = new Button("Spring");
        Button summerBtn = new Button("Summer");
        Button fallBtn = new Button("Fall");
        Button winterBtn = new Button("Winter");
        HBox seasonsBox = new HBox(5, springBtn, summerBtn, fallBtn, winterBtn);
        seasonsBox.setAlignment(Pos.CENTER);

        // Next button to go to initial farm UI
        Button nextBtn = new Button("Next");

        // VBox for the config screen
        VBox configBox = new VBox(15, nameBox, difficultyBox, seedsBox, seasonsBox);
        configBox.setPrefSize(600, 450);
        configBox.setAlignment(Pos.CENTER);

        easyBtn.setOnAction(e -> {
            difficulty = 1;
        });

        mediumBtn.setOnAction(e -> {
            difficulty = 2;
        });

        difficultBtn.setOnAction(e -> {
            difficulty = 3;
        });

        seed1Btn.setOnAction(e -> {

        });

        seed2Btn.setOnAction(e -> {

        });

        seed3Btn.setOnAction(e -> {

        });

        springBtn.setOnAction(e -> {

        });

        summerBtn.setOnAction(e -> {

        });

        fallBtn.setOnAction(e -> {

        });

        winterBtn.setOnAction(e -> {

        });

        nextBtn.setOnAction(e -> {
            String inputName = nameField.getText();
//            if (inputName != null && !inputName.trim().equals("") && difficulty != 0) {    //finish this line
//                //store data in player and farm and go to next scene
//            }
        });

        //Load configuration menu and transition
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(new Scene(configBox, 1080, 720));
            }
        });


    }
}
