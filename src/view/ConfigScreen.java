package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;

public class ConfigScreen {
    private int width;
    private int height;
    private TextField nameField;
    private Button easyBtn;
    private Button mediumBtn;
    private Button difficultBtn;
    private Button riceBtn;
    private Button cornBtn;
    private Button potatoBtn;
    private Button springBtn;
    private Button summerBtn;
    private Button fallBtn;
    private Button winterBtn;
    private Button nextBtn;

    private ConfigScreen() { }
    public ConfigScreen(int w, int h) {
        width = w;
        height = h;
        nameField = new TextField();
        nameField.setPromptText("Name");
        easyBtn = new Button("Easy");
        mediumBtn = new Button("Medium");
        difficultBtn = new Button("Difficult");
        riceBtn = new Button("Rice");
        cornBtn = new Button("Corn");
        potatoBtn = new Button("Potato");
        springBtn = new Button("Spring");
        summerBtn = new Button("Summer");
        fallBtn = new Button("Fall");
        winterBtn = new Button("Winter");
        nextBtn = new Button("Next");
    }

    public TextField getNameField() {
        return nameField;
    }

    public Button getEasyBtn() {
        return  easyBtn;
    }

    public Button getMediumBtn() {
        return mediumBtn;
    }

    public Button getDifficultBtn() {
        return difficultBtn;
    }

    public Button getRiceBtn() {
        return riceBtn;
    }

    public Button getCornBtn() {
        return cornBtn;
    }

    public Button getPotatoBtn() {
        return potatoBtn;
    }

    public Button getSpringBtn() {
        return springBtn;
    }

    public Button getSummerBtn() {
        return summerBtn;
    }

    public Button getFallBtn() {
        return fallBtn;
    }

    public Button getWinterBtn() {
        return winterBtn;
    }

    public Button getNextBtn() {
        return nextBtn;
    }

    public Scene getScene() {
        // Field for user to enter name / HBox
        Text nameFieldText = new Text("Name:");
        HBox nameBox = new HBox(5, nameFieldText, nameField);
        nameBox.setAlignment(Pos.CENTER);

        // Difficulty buttons / HBox
        Text difficultyText = new Text("Difficulty: ");
        HBox difficultyBox = new HBox(5, difficultyText, easyBtn, mediumBtn, difficultBtn);
        difficultyBox.setAlignment(Pos.CENTER);

        // Starting seed buttons / HBox
        Text seedText = new Text("Starting Seed:");
        HBox seedsBox = new HBox(5, seedText, riceBtn, cornBtn, potatoBtn);
        seedsBox.setAlignment(Pos.CENTER);

        // Starting season buttons / HBox
        Text seasonText = new Text("Starting Season:");
        HBox seasonsBox = new HBox(5, seasonText, springBtn, summerBtn, fallBtn, winterBtn);
        seasonsBox.setAlignment(Pos.CENTER);

        // VBox for the config screen
        VBox configBox = new VBox(15, nameBox, difficultyBox, seedsBox, seasonsBox, nextBtn);
        configBox.setPrefSize(600, 450);
        configBox.setAlignment(Pos.CENTER);

        return new Scene(configBox, width, height);

    }

}
