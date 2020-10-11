package view;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
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
    private Button[] plotsBtn = new Button[10];
    private HashMap<Object, Integer> inventory;
    private Button marketBtn;
    private Image dirt = new Image("dirt_plot.png");
    private Image cornSeed = new Image("seed_plot.png");
    private Image potatoSeed = new Image("seed_plot.png");
    private Image riceSeed = new Image("seed_plot.png");
    private Image immatureCorn = new Image("immature_corn.png");
    private Image immaturePotato = new Image("immature_potato.png");
    private Image immatureRice = new Image("immature_rice.png");
    private Image corn = new Image("corn_plot.png");
    private Image potato = new Image("potato_plot.png");
    private Image rice = new Image("rice_plot.png");


    private InitialUIScreen() { }
    public InitialUIScreen(int w, int h, int m, int d, HashMap<Object, Integer> inv) {
        width = w;
        height = h;
        money = m;
        day = d;
        inventory = inv;
        marketBtn = new Button("go to market");
    }

    public Button getMarketBtn() {
        return marketBtn;
    }
    public Button[] getPlotsBtn() {
        return plotsBtn;
    }

    public void setPlant(Button btn, Crop c) {

        switch(c.getSpecies().getName() + " " + c.getStage()) {
            case "Potato 1":
                btn.setGraphic(new ImageView(potatoSeed));
                btn.setText("Potato Seed");
                break;
            case "Potato 2":
                btn.setGraphic(new ImageView(immaturePotato));
                btn.setText("Immature Potato");
                break;
            case "Potato 3":
                btn.setGraphic(new ImageView(potato));
                btn.setText("Potato");
                break;
            case "Rice 1":
                btn.setGraphic(new ImageView(riceSeed));
                btn.setText("Rice Seed");
                break;
            case "Rice 2":
                btn.setGraphic(new ImageView(immatureRice));
                btn.setText("Immature Rice");
                break;
            case "Rice 3":
                btn.setGraphic(new ImageView(rice));
                btn.setText("Rice");
                break;
            case "Corn 1":
                btn.setGraphic(new ImageView(cornSeed));
                btn.setText("Corn Seed");
                break;
            case "Corn 2":
                btn.setGraphic(new ImageView(immatureCorn));
                btn.setText("Immature Corn");
                break;
            case "Corn 3":
                btn.setGraphic(new ImageView(corn));
                btn.setText("Corn");
                break;
            default:
                btn.setGraphic(new ImageView(dirt));
                btn.setText("dirt");
                break;

        }
    }

    public void setDirt(Button btn) {
        btn.setGraphic(new ImageView(dirt));
        btn.setText("dirt");
    }


    public Scene getScene() {
        HBox plotRow1 = new HBox();
        HBox plotRow2 = new HBox();
        Text moneyText = new Text("Money: " + money);
        moneyText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text dayText = new Text("Day: " + day);
        dayText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));

        //Create plots
        for (int i = 0; i < 10; i++) {
            plotsBtn[i].setMinWidth(216);
            plotsBtn[i].setMinHeight(210);
            plotsBtn[i].setMaxWidth(216);
            plotsBtn[i].setMaxHeight(210);
            if (i < 5) {
                plotRow1.getChildren().add(plotsBtn[i]);
            } else {
                plotRow2.getChildren().add(plotsBtn[i]);
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


        VBox initialFarm = new VBox(moneyText, dayText, plotRow1, plotRow2, inventoryDisplay, marketBtn);
        return new Scene(initialFarm, width, height);
    }
}
