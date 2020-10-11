package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Crop;
import model.Market;
import model.Player;

import java.util.HashMap;

public class MarketScreen {
    private int width;
    private int height;
    private Player player;
    private Market market;
    private Button buyPotatoBtn;
    private Button buyCornBtn;
    private Button buyRiceBtn;
    private Button backBtn;

    private MarketScreen() { }

    public MarketScreen(int w, int h, Player p, Market m) {
        width = w;
        height = h;
        player = p;
        market = m;
        buyPotatoBtn = new Button("Click to Buy");
        buyCornBtn = new Button("Click to Buy");
        buyRiceBtn = new Button("Click to Buy");
        backBtn = new Button("Back");
    }

    public Button getBuyPotatoBtn() {
        return buyPotatoBtn;
    }
    public Button getBuyCornBtn() {
        return buyCornBtn;
    }
    public Button getBuyRiceBtn() {
        return buyRiceBtn;
    }
    public Button getBackBtn() {
        return backBtn;
    }

    public Scene getScene() {
        Text marketTitle = new Text("Market");
        Text playerMoney = new Text("Player Money: " + player.getMoney());

        //inventory
        VBox inventoryDisplay = new VBox();
        inventoryDisplay.getChildren().add(new Text("Inventory"));
        HashMap<Object, Integer> inventory = player.getInventory();

        for (Object key : inventory.keySet()) {
            String cropName;
            if (key.getClass() == Crop.class) {
                Crop c = (Crop) key;
                if (c.getStage() == 3) {
                    cropName = c.getSpecies().getName();
                } else {
                    cropName = c.getSpecies().getName() + " Seed";
                }
                Text crop = new Text(cropName + ": " + inventory.get(key));
                inventoryDisplay.getChildren().add(crop);
            }
        }

        //Buy section for crops
        VBox buyBox = new VBox(new Text("Buy Here"));
        HashMap<Crop, Integer> stock = market.getStock();
        for (Crop key : stock.keySet()) {
            String cropName = key.getSpecies().getName();
            Text cropLabel = new Text(cropName + " Cost: " + stock.get(key));

            HBox crop;
            if (cropName.equals("Potato")) {
                crop = new HBox(buyPotatoBtn, cropLabel);
            } else if (cropName.equals("Corn")) {
                crop = new HBox(buyCornBtn, cropLabel);
            } else {
                crop = new HBox(buyRiceBtn, cropLabel);
            }
            buyBox.getChildren().add(crop);
        }

        VBox market = new VBox(marketTitle, playerMoney, inventoryDisplay, buyBox, backBtn);
        return new Scene(market, width, height);
    }
}
