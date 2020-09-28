import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DigitalFarm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Digital Farm");

        //Creating start menu with start button
        main.Player player = new main.Player();
        main.Farm farm = new main.Farm();
        StackPane startMenu = new StackPane();
        Button btn = new Button();
        btn.setText("Start");
        btn.setMinSize(150, 30);
        Image image = new Image("Digital_Farm.png");
        ImageView iv = new ImageView(image);
        iv.fitWidthProperty().bind(primaryStage.widthProperty());
        iv.fitHeightProperty().bind(primaryStage.heightProperty());

        //Create config screen
        VBox config = FXMLLoader.load(getClass().getResource("configscreen.fxml"));


        //Create initial farm UI
        VBox initialFarm = new VBox();
        HBox plotRow1 = new HBox();
        HBox plotRow2 = new HBox();
        Text money = new Text("Money: " + player.getMoney());
        money.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text day = new Text("Day: " + farm.getDay());
        day.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Image dirt = new Image("dirt_plot.png");
        //Create plots
        ImageView[] plots = new ImageView[10];
        for (int i = 0; i < 10; i++) {
            plots[i] = new ImageView(dirt);
            plots[i].setFitHeight(210);
            plots[i].setFitWidth(216);
            if (i < 5) {
                plotRow1.getChildren().add(plots[i]);
            } else {
                plotRow2.getChildren().add(plots[i]);
            }
        }

        initialFarm.getChildren().add(money);
        initialFarm.getChildren().add(day);

        initialFarm.getChildren().add(plotRow1);
        initialFarm.getChildren().add(plotRow2);


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            //Load configuration menu and transition
            public void handle(ActionEvent actionEvent) {
                //primaryStage.setScene(new Scene(config, 1080, 720));
                primaryStage.setScene(new Scene(initialFarm, 1080, 720));
            }
        });

        // Show start menu
        startMenu.getChildren().add(iv);
        startMenu.getChildren().add(btn);
        primaryStage.setScene(new Scene(startMenu, 1080, 720));
        primaryStage.show();

    }
}
