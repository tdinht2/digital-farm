package view;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EndGameScreen {
        private int width;
        private int height;
        private Button startOverBtn;
        private Text gameOver;


        private EndGameScreen() { }
        public EndGameScreen(int w, int h) {
            width = w;
            height = h;
            startOverBtn = new Button("Start Over");
            gameOver = new Text("Game Over!");
        }


        public Button getStartOverBtn() {
            return startOverBtn;
        }

        public Scene getScene() {
            VBox configBox = new VBox(15,gameOver,startOverBtn);
            configBox.setPrefSize(600, 450);
            configBox.setAlignment(Pos.CENTER);
            return new Scene(configBox, width, height);
        }
    }
