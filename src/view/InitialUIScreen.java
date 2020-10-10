package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Crop;

import java.util.HashMap;

public class InitialUIScreen {
    private int width;
    private int height;
    private int money;
    private int day;
    private HashMap<Object, Integer> inventory;

    private InitialUIScreen() { }
    public InitialUIScreen(int w, int h, int m, int d, HashMap<Object, Integer> inv) {
        width = w;
        height = h;
        money = m;
        day = d;
        inventory = inv;
    }

    public Scene getScene() {
        HBox plotRow1 = new HBox();
        HBox plotRow2 = new HBox();
        Text moneyText = new Text("Money: " + money);
        moneyText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text dayText = new Text("Day: " + day);
        dayText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
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

        //create inventory
        VBox inventoryDisplay = new VBox();
        inventoryDisplay.getChildren().add(new Text("Inventory"));

        for (Object key : inventory.keySet()) {
            if (key.getClass() == Crop.class) {
                Crop c = (Crop) key;
                String cropName = c.getSpecies().getName();
                Text crop = new Text(cropName + ": " + inventory.get(key));
                inventoryDisplay.getChildren().add(crop);
            }
        }

        VBox initialFarm = new VBox(moneyText, dayText, plotRow1, plotRow2, inventoryDisplay);
        return new Scene(initialFarm, width, height);
    }
}
