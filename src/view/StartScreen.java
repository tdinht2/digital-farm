package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class StartScreen {
    private int width;
    private int height;
    private Button startButton;

    private StartScreen() {}
    public StartScreen(int w, int h) {
        width = w;
        height = h;
        startButton = new Button("Start");
        startButton.setMinSize(150, 30);
    }

    public Button getStartButton() {
        return startButton;
    }

    public Scene getScene() {
        StackPane stackPane = new StackPane();
        Image image = new Image("Digital_Farm.png");
        ImageView iv = new ImageView(image);
        iv.setFitWidth(width);
        iv.setFitHeight(height);
        stackPane.getChildren().add(iv);
        stackPane.getChildren().add(startButton);
        return new Scene(stackPane, width, height);
    }
}
