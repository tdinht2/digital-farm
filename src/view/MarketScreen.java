package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Crop;
import model.Item;
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
    private Button buyFertBtn;
    private Button buyPestBtn;
    private Button buyPlotBtn;
    private Button buyTractorBtn;
    private Button buyIrrigationBtn;
    private Button sellPotatoSeedBtn;
    private Button sellCornSeedBtn;
    private Button sellRiceSeedBtn;
    private Button sellPotatoBtn;
    private Button sellCornBtn;
    private Button sellRiceBtn;
    private Button backBtn;
    private Button sellPestCornBtn;
    private Button sellPestRiceBtn;
    private Button sellPestPotatoBtn;
    private Button buyAirplaneTicketBtn;

    private MarketScreen() { }

    public MarketScreen(int w, int h, Player p, Market m) {
        width = w;
        height = h;
        player = p;
        market = m;
        buyPotatoBtn = new Button("Buy");
        buyCornBtn = new Button("Buy");
        buyRiceBtn = new Button("Buy");
        buyFertBtn = new Button("Buy");
        buyPestBtn = new Button("Buy");
        buyPlotBtn = new Button("Buy");
        buyAirplaneTicketBtn = new Button("Buy");
        buyTractorBtn = new Button("Buy");
        buyIrrigationBtn = new Button("Buy");
        sellPotatoSeedBtn = new Button("Sell for " + m.sell(new Crop(1, Crop.Type.Potato), 1));
        sellCornSeedBtn = new Button("Sell for " + m.sell(new Crop(1, Crop.Type.Corn), 1));
        sellRiceSeedBtn = new Button("Sell for " + m.sell(new Crop(1, Crop.Type.Rice), 1));
        sellPotatoBtn = new Button("Sell for " + m.sell(new Crop(7, Crop.Type.Potato), 1));
        sellCornBtn = new Button("Sell for " + m.sell(new Crop(7, Crop.Type.Corn), 1));
        sellRiceBtn = new Button("Sell for " + m.sell(new Crop(7, Crop.Type.Rice), 1));
        backBtn = new Button("Back");

        Crop pestPotato = new Crop(7, Crop.Type.PesticidedPotato);
        pestPotato.fertilize();
        Crop pestCorn = new Crop(7, Crop.Type.PesticidedCorn);
        pestCorn.fertilize();
        Crop pestRice = new Crop(7, Crop.Type.PesticidedRice);
        pestRice.fertilize();
        sellPestPotatoBtn = new Button("Sell for " + m.sell(pestPotato, 1));
        sellPestCornBtn = new Button("Sell for " + m.sell(pestCorn, 1));
        sellPestRiceBtn = new Button("Sell for " + m.sell(pestRice, 1));
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
    public Button getSellPotatoSeedBtn() {
        return sellPotatoSeedBtn;
    }
    public Button getSellCornSeedBtn() {
        return sellCornSeedBtn;
    }
    public Button getSellRiceSeedBtn() {
        return sellRiceSeedBtn;
    }
    public Button getSellPotatoBtn() {
        return sellPotatoBtn;
    }
    public Button getSellCornBtn() {
        return sellCornBtn;
    }
    public Button getSellRiceBtn() {
        return sellRiceBtn;
    }
    public Button getBackBtn() {
        return backBtn;
    }
    public Button getBuyFertBtn() {
        return buyFertBtn;
    }
    public Button getBuyPestBtn() {
        return buyPestBtn;
    }
    public Button getBuyPlotBtn() { return buyPlotBtn; }
    public Button getBuyTractorBtn() { return buyTractorBtn; }
    public Button getBuyIrrigationBtn() { return buyIrrigationBtn; }
    public Button getSellPestCornBtn() {
        return sellPestCornBtn;
    }
    public Button getBuyAirplaneTicketBtn() {return buyAirplaneTicketBtn;}
    public Button getSellPestPotatoBtn() {
        return sellPestPotatoBtn;
    }
    public Button getSellPestRiceBtn() {
        return sellPestRiceBtn;
    }
    public Market getMarket() {return market;}

    public Scene getScene() {
        Text marketTitle = new Text("Market");
        Text playerMoney = new Text("Player Money: " + player.getMoney());

        //inventory
        VBox inventoryDisplay = new VBox();
        inventoryDisplay.getChildren().add(new Text("Inventory"));
        HashMap<Object, Integer> inventory = player.getInventory();

        for (Object key : inventory.keySet()) {
            String cropName;
            Text crop;
            HBox sellDisplay = new HBox();
            if (key instanceof Item) {
                Item item = (Item) key;
                Text itemCount = new Text(item.getName() + ": " + inventory.get(key));
                sellDisplay.getChildren().add(itemCount);
                inventoryDisplay.getChildren().add(sellDisplay);
            }
            if (key instanceof Crop) {
                Crop c = (Crop) key;
                if (c.getStage() == 7) {
                    cropName = c.getSpecies().getName();
                    crop = new Text(cropName + ": " + inventory.get(c));
                    if (cropName.equals("Corn")) {
                        sellDisplay.getChildren().addAll(crop, getSellCornBtn());
                    } else if (cropName.equals("Potato")) {
                        sellDisplay.getChildren().addAll(crop, getSellPotatoBtn());
                    } else if (cropName.equals("Rice")) {
                        sellDisplay.getChildren().addAll(crop, getSellRiceBtn());
                    } else if (cropName.equals("Pesticided Corn")) {
                        sellDisplay.getChildren().addAll(crop, getSellPestCornBtn());
                    } else if (cropName.equals("Pesticided Potato")) {
                        sellDisplay.getChildren().addAll(crop, getSellPestPotatoBtn());
                    } else if (cropName.equals("Pesticided Rice")) {
                        sellDisplay.getChildren().addAll(crop, getSellPestRiceBtn());
                    }
                } else {
                    cropName = c.getSpecies().getName() + " Seed";
                    crop = new Text(cropName + ": " + inventory.get(c));
                    if (cropName.equals("Corn Seed")) {
                        sellDisplay.getChildren().addAll(crop, getSellCornSeedBtn());
                    } else if (cropName.equals("Potato Seed")) {
                        sellDisplay.getChildren().addAll(crop, getSellPotatoSeedBtn());
                    } else if (cropName.equals("Rice Seed")) {
                        sellDisplay.getChildren().addAll(crop, getSellRiceSeedBtn());
                    }
                }
                inventoryDisplay.getChildren().add(sellDisplay);
            }
        }

        //Buy section for crops
        VBox buyBox = new VBox(new Text("Buy Here"));
        HashMap<Object, Integer> stock = market.getStock();
        for (Object key : stock.keySet()) {
            if (key instanceof Item) {
                Item item = (Item) key;
                String itemName = item.getName();
                Text itemLabel = new Text(itemName + " Cost: " + stock.get(item));

                HBox itemBox;
                if (itemName.equals("Fertilizer")) {
                    itemBox = new HBox(buyFertBtn, itemLabel);
                } else if (itemName.equals("Pesticide")){
                    itemBox = new HBox(buyPestBtn, itemLabel);
                } else if (itemName.equals("Plot")) {
                    itemBox = new HBox(buyPlotBtn, itemLabel);
                } else if (itemName.equals("Tractor")) {
                    itemBox = new HBox(buyTractorBtn, itemLabel);
                } else if (itemName.equals("Irrigation")) {
                        itemBox = new HBox(buyIrrigationBtn, itemLabel);
                } else {
                    itemBox = new HBox(buyAirplaneTicketBtn, itemLabel);
                }
                buyBox.getChildren().add(itemBox);
            }
            if (key instanceof Crop) {
                Crop crop = (Crop) key;
                String cropName = crop.getSpecies().getName();
                Text cropLabel = new Text(cropName + " Cost: " + stock.get(crop));

                HBox cropBox;
                if (crop.getStage() == 1) {
                    if (cropName.equals("Potato")) {
                        cropBox = new HBox(buyPotatoBtn, cropLabel);
                        buyBox.getChildren().add(cropBox);
                    } else if (cropName.equals("Corn")) {
                        cropBox = new HBox(buyCornBtn, cropLabel);
                        buyBox.getChildren().add(cropBox);
                    } else if (cropName.equals("Rice")) {
                        cropBox = new HBox(buyRiceBtn, cropLabel);
                        buyBox.getChildren().add(cropBox);
                    }
                }
            }
        }

        VBox market = new VBox(marketTitle, playerMoney, buyBox, inventoryDisplay, backBtn);
        market.setSpacing(15);
        return new Scene(market, width, height);
    }
}
