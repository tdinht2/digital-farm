package view;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WinScreen {
    private int width;
    private int height;
    private Image beach;
    private Text winOver;


    private WinScreen() { }
    public WinScreen(int w, int h) {
        width = w;
        height = h;
        winOver = new Text("VACATION EPIC GAMER WIN!");
        beach = new Image("beach.jpg");
    }

    public Scene getScene() {
        VBox configBox = new VBox(15,winOver,new ImageView(beach));
        configBox.setPrefSize(1200, 1000);
        configBox.setAlignment(Pos.CENTER);
        return new Scene(configBox, width, height);
    }
}
