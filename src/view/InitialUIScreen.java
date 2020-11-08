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
import model.Item;

import java.util.HashMap;

public class InitialUIScreen {
    private int width;
    private int height;
    private int money;
    private int day;
    private Button[] plotsBtn = new Button[10];
    private Button[] waterBtns = new Button[10];
    private Button[] fertBtns = new Button[10];
    private Button[] pestBtns = new Button[10];
    private HashMap<Object, Integer> inventory;
    private Button marketBtn;
    private Button timeBtn;
    private Button plantPotatoBtn = new Button("Plant Potato");
    private Button plantRiceBtn = new Button("Plant Rice");
    private Button plantCornBtn = new Button("Plant Corn");

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
    private Image waterLevel0 = new Image("water_level_0.png");
    private Image waterLevel1 = new Image("water_level_1.png");
    private Image waterLevel2 = new Image("water_level_2.png");
    private Image waterLevel3 = new Image("water_level_3.png");
    private Image waterLevel4 = new Image("water_level_4.png");
    private Image deadPlant = new Image("dead_plant.png");
    private Image fertLevel0 = new Image("fert_level_0.png");
    private Image fertLevel1 = new Image("fert_level_1.png");
    private Image fertLevel2 = new Image("fert_level_2.png");
    private Image fertLevel3 = new Image("fert_level_3.png");
    private Image pestOn = new Image("pest_on.png");
    private Image pestOff = new Image("pest_off.png");


    private InitialUIScreen() { }
    public InitialUIScreen(int w, int h, int m, int d, HashMap<Object, Integer> inv) {
        width = w;
        height = h;
        money = m;
        day = d;
        inventory = inv;
        marketBtn = new Button("Go to Market");
        timeBtn = new Button("Next Day");
    }

    public void incrementDay() {
        this.day++;
    }
    public Button getMarketBtn() {
        return marketBtn;
    }
    public Button[] getPlotsBtn() {
        return plotsBtn;
    }

    public Button getTimeBtn() {
        return timeBtn;
    }

    public Button[] getWaterBtns() {
        return waterBtns;
    }
    public Button[] getFertBtns() {return fertBtns;}
    public Button[] getPestBtns() {return pestBtns;}

    public Button getPlantPotatoBtn() {
        return plantPotatoBtn;
    }
    public Button getPlantRiceBtn() {
        return plantRiceBtn;
    }
    public Button getPlantCornBtn() {
        return plantCornBtn;
    }

    public void setWater(Button btn, Crop c) {
        switch (c.getWaterLevel()) {
        case 0:
            btn.setGraphic(new ImageView(waterLevel0));
            btn.setText("Water 0");
            break;
        case 1:
            btn.setGraphic(new ImageView(waterLevel1));
            btn.setText("Water 1");
            break;
        case 2:
            btn.setGraphic(new ImageView(waterLevel2));
            btn.setText("Water 2");
            break;
        case 3:
            btn.setGraphic(new ImageView(waterLevel3));
            btn.setText("Water 3");
            break;
        case 4:
            btn.setGraphic(new ImageView(waterLevel4));
            btn.setText("Water 4");
            break;
        default:
            setEmptyWater(btn);
        }
    }

    public void setFert(Button btn, Crop c) {
        switch (c.getFertLevel()) {
            case 0:
                btn.setGraphic(new ImageView(fertLevel0));
                btn.setText("Fertilizer 0");
                break;
            case 1:
                btn.setGraphic(new ImageView(fertLevel1));
                btn.setText("Fertilizer 1");
                break;
            case 2:
                btn.setGraphic(new ImageView(fertLevel2));
                btn.setText("Fertilizer 2");
                break;
            case 3:
                btn.setGraphic(new ImageView(fertLevel3));
                btn.setText("Fertilizer 3");
                break;
            default:
                break;
        }
    }

    public void setPest(Button btn, Crop c) {
        if (c.isPesticides()) {
            btn.setGraphic(new ImageView(pestOn));
            btn.setText("pestOn");
        } else {
            btn.setGraphic(new ImageView(pestOff));
            btn.setText("pestOff");
        }
    }
    public void setEmptyPest(Button btn) {
        btn.setGraphic(new ImageView(pestOff));
        btn.setText("pestOff");
    }

    public void setEmptyWater(Button btn) {
        btn.setGraphic(new ImageView(waterLevel0));
        btn.setText("Water 0");
    }

    public void setEmptyFert(Button btn) {
        btn.setGraphic(new ImageView(fertLevel0));
        btn.setText("Fertilizer 0");
    }
    public void setPlant(Button btn, Crop c) {
        if (c.getStage() == 0) {
            btn.setGraphic(new ImageView(deadPlant));
            btn.setText("Dead Plant");
            return;
        } else {    // plant is alive
            if (c.getSpecies().getName().equals("Potato")) {
                if (c.getStage() == 1) {
                    btn.setGraphic(new ImageView(potatoSeed));
                    btn.setText("Potato Seed");
                } else if (c.getStage() < 7) { // 2-6, immature
                    btn.setGraphic(new ImageView(immaturePotato));
                    btn.setText("Immature Potato");
                } else {    // 7, mature
                    btn.setGraphic(new ImageView(potato));
                    btn.setText("Potato");
                }
            } else if (c.getSpecies().getName().equals("Rice")) {
                if (c.getStage() == 1) {
                    btn.setGraphic(new ImageView(riceSeed));
                    btn.setText("Rice Seed");
                } else if (c.getStage() < 7) { // 2-6, immature
                    btn.setGraphic(new ImageView(immatureRice));
                    btn.setText("Immature Rice");
                } else {    // 7, mature
                    btn.setGraphic(new ImageView(rice));
                    btn.setText("Rice");
                }
            } else if (c.getSpecies().getName().equals("Corn")) {
                if (c.getStage() == 1) {
                    btn.setGraphic(new ImageView(cornSeed));
                    btn.setText("Corn Seed");
                } else if (c.getStage() < 7) { // 2-6, immature
                    btn.setGraphic(new ImageView(immatureCorn));
                    btn.setText("Immature Corn");
                } else {    // 7, mature
                    btn.setGraphic(new ImageView(corn));
                    btn.setText("Corn");
                }
            }
        }
    }

    public void setDirt(Button btn) {
        btn.setGraphic(new ImageView(dirt));
        btn.setText("dirt");
    }


    public Scene getScene() {
        HBox plotRow1 = new HBox();
        HBox plotRow2 = new HBox();
        HBox waterRow1 = new HBox();
        HBox waterRow2 = new HBox();
        HBox fertRow1 = new HBox();
        HBox fertRow2 = new HBox();
        HBox pestRow1 = new HBox();
        HBox pestRow2 = new HBox();
        HBox plantBtns = new HBox();
        plantBtns.getChildren().add(plantCornBtn);
        plantBtns.getChildren().add(plantRiceBtn);
        plantBtns.getChildren().add(plantPotatoBtn);
        Text moneyText = new Text("Money: " + money);
        moneyText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text dayText = new Text("Day: " + day);
        dayText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));

        //Create plots
        for (int i = 0; i < 10; i++) {
            plotsBtn[i].setMinWidth(234);
            plotsBtn[i].setMinHeight(210);
            plotsBtn[i].setMaxWidth(234);
            plotsBtn[i].setMaxHeight(210);
            waterBtns[i].setMinWidth(234);
            waterBtns[i].setMinHeight(29);
            waterBtns[i].setMaxWidth(234);
            waterBtns[i].setMaxHeight(29);
            fertBtns[i].setMinWidth(234);
            fertBtns[i].setMinHeight(28);
            fertBtns[i].setMaxWidth(234);
            fertBtns[i].setMaxHeight(28);
            pestBtns[i].setMinWidth(234);
            pestBtns[i].setMinHeight(28);
            pestBtns[i].setMaxWidth(234);
            pestBtns[i].setMaxHeight(28);
            if (i < 5) {
                plotRow1.getChildren().add(plotsBtn[i]);
                waterRow1.getChildren().add(waterBtns[i]);
                fertRow1.getChildren().add(fertBtns[i]);
                pestRow1.getChildren().add(pestBtns[i]);
            } else {
                plotRow2.getChildren().add(plotsBtn[i]);
                waterRow2.getChildren().add(waterBtns[i]);
                fertRow2.getChildren().add(fertBtns[i]);
                pestRow2.getChildren().add(pestBtns[i]);
            }
        }
        //create inventory
        VBox inventoryDisplay = new VBox();
        inventoryDisplay.getChildren().add(new Text("Inventory"));

        for (Object key : inventory.keySet()) {
            String cropName;
            if (key instanceof Item) {
                Item item = (Item) key;
                Text itemTag = new Text(item.getName() + ": " + inventory.get(key));
                inventoryDisplay.getChildren().add(itemTag);
            }
            if (key.getClass() == Crop.class) {
                Crop c = (Crop) key;
                if (c.getStage() == 7) {
                    cropName = c.getSpecies().getName();
                } else {
                    cropName = c.getSpecies().getName() + " Seed";
                }
                Text crop = new Text(cropName + ": " + inventory.get(key));
                inventoryDisplay.getChildren().add(crop);
            }
        }

        VBox initialFarm = new VBox(moneyText, dayText, plotRow1,pestRow1,fertRow1, waterRow1, plotRow2,
                pestRow2,fertRow2, waterRow2, inventoryDisplay, plantBtns, marketBtn, timeBtn);

        return new Scene(initialFarm, width, height);
    }
}
