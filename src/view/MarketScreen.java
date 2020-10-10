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

    private MarketScreen() {}

    public MarketScreen(int w, int h, Player p, Market m) {
        width = w;
        height = h;
        player = p;
        market = m;
        buyPotatoBtn = new Button("Click to Buy");
        buyCornBtn = new Button("Click to Buy");
        buyRiceBtn = new Button("Click to Buy");
    }

    public Button getBuyPotatoBtn() { return buyPotatoBtn; }
    public Button getBuyCornBtn() { return buyCornBtn; }
    public Button getBuyRiceBtn() { return buyRiceBtn; }

    public Scene getScene() {
        Text marketTitle = new Text("Market");
        Text playerMoney = new Text("Money: " + String.valueOf(player.getMoney()));

        //Buy section for crops
        VBox buyBox = new VBox(new Text("Buy Here"));
        HashMap<Crop, Integer> stock = market.getStock();
        for (Crop key : stock.keySet()) {
            Text cropLabel = new Text(key.getSpecies().getName() + ": " + stock.get(key) + " in stock!");
            //need to assign button depending on what crop it is
            HBox oneCrop = new HBox(buyPotatoBtn, cropLabel);
            buyBox.getChildren().add(oneCrop);
        }

        VBox market = new VBox(marketTitle, playerMoney, buyBox);
        return new Scene(market, width, height);
    }
}
