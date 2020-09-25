import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class digitalFarm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Digital Farm");

        //Creating start menu with start button
        StackPane startMenu = new StackPane();
        Button btn = new Button();
        btn.setText("Start");
        btn.setMinSize(150, 30);
        Image image = new Image("Digital_Farm.png");
        ImageView iv = new ImageView(image);
        iv.fitWidthProperty().bind(primaryStage.widthProperty());
        iv.fitHeightProperty().bind(primaryStage.heightProperty());

        //Create Initial Menu
        StackPane config = new StackPane();


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            //Load configuration menu and transition
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(new Scene(config, 1080, 720));
            }
        });

        // Show start menu
        startMenu.getChildren().add(iv);
        startMenu.getChildren().add(btn);
        primaryStage.setScene(new Scene(startMenu, 1080, 720));
        primaryStage.show();
    }
}
