package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Crop;
import model.Market;
import model.Player;
import model.Farm;
import view.MarketScreen;
import view.StartScreen;
import view.ConfigScreen;
import view.InitialUIScreen;

import java.util.HashMap;

public class DigitalFarm extends Application {
    private Stage mainWindow;
    private Player player;
    private Farm farm;
    private final int width = 1200;
    private final int height = 900;
    private int difficulty;
    private Crop startCrop;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        primaryStage.setTitle("Digital Farm");
        showStartScreen();
    }

    private void showStartScreen() {
        StartScreen startScreen = new StartScreen(width, height);
        Button startButton = startScreen.getStartButton();
        startButton.setOnAction(e -> {
            goToConfigScreen();
        });
        Scene scene = startScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToConfigScreen() {
        ConfigScreen configScreen = new ConfigScreen(width, height);
        TextField nameField = configScreen.getNameField();


        Button easyBtn = configScreen.getEasyBtn();
        easyBtn.setOnAction(e -> {
            difficulty = 1;
        });

        Button mediumBtn = configScreen.getMediumBtn();
        mediumBtn.setOnAction(e -> {
            difficulty = 2;
        });

        Button difficultBtn = configScreen.getDifficultBtn();
        difficultBtn.setOnAction(e -> {
            difficulty = 3;
        });

        Button riceBtn = configScreen.getRiceBtn();
        riceBtn.setOnAction(e -> {
            startCrop = new Crop(1, Crop.Type.Rice);
        });

        Button cornBtn = configScreen.getCornBtn();
        cornBtn.setOnAction(e -> {
            startCrop = new Crop(1, Crop.Type.Corn);
        });

        Button potatoBtn = configScreen.getPotatoBtn();
        potatoBtn.setOnAction(e -> {
            startCrop = new Crop(1, Crop.Type.Potato);
        });

        Button springBtn = configScreen.getSpringBtn();
        springBtn.setOnAction(e -> {

        });

        Button summerBtn = configScreen.getSummerBtn();
        summerBtn.setOnAction(e -> {

        });

        Button fallBtn = configScreen.getFallBtn();
        fallBtn.setOnAction(e -> {

        });

        Button winterBtn = configScreen.getWinterBtn();
        winterBtn.setOnAction(e -> {

        });

        Button nextBtn = configScreen.getNextBtn();
        nextBtn.setOnAction(e -> {
            String inputName = nameField.getText();
            //unfinished, account for season
            if (inputName != null && !inputName.trim().equals("") && difficulty != 0
                    && startCrop != null) {
                player = new Player(inputName, 0, difficulty);
                player.addItem(startCrop, 1);
                player.addItem(new Crop(1, Crop.Type.Corn), 0);
                player.addItem(new Crop(1, Crop.Type.Potato), 0);
                player.addItem(new Crop(1, Crop.Type.Rice), 0);
                farm = new Farm(difficulty);
                goToInitialUIScreen();
            }
        });

        Scene scene = configScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }
    private void goToInitialUIScreen() {
        InitialUIScreen initUIScreen = new InitialUIScreen(width, height, player.getMoney(),
                farm.getDay(), player.getInventory());
        Button marketBtn = initUIScreen.getMarketBtn();
        Button plantCornBtn = initUIScreen.getPlantCornBtn();
        Button plantRiceBtn = initUIScreen.getPlantRiceBtn();
        Button plantPotatoBtn = initUIScreen.getPlantPotatoBtn();
        marketBtn.setOnAction(e -> {
            goToMarketScreen();
        });

        Button[] plotsBtn = initUIScreen.getPlotsBtn();
        Button[] waterBtns = initUIScreen.getWaterBtns();
        for (int i = 0; i < plotsBtn.length; i++) {
            plotsBtn[i] = new Button();
            waterBtns[i] = new Button();
        }

        Button timeBtn = initUIScreen.getTimeBtn();
        timeBtn.setOnAction(e -> {
            farm.nextDay();
            initUIScreen.incrementDay();
            refreshPlots(initUIScreen, plotsBtn, waterBtns);
            mainWindow.setScene(initUIScreen.getScene());
        });

        plantCornBtn.setOnAction(e -> {
            Crop cornSeed = new Crop(1, Crop.Type.Corn);
            if (farm.plant(cornSeed, player.getInventory().get(cornSeed))) {
                player.subtractItem(cornSeed, 1);
                refreshPlots(initUIScreen, plotsBtn, waterBtns);
            }
        });

        plantRiceBtn.setOnAction(e -> {
            Crop riceSeed = new Crop(1, Crop.Type.Rice);
            if (farm.plant(riceSeed, player.getInventory().get(riceSeed))) {
                player.subtractItem(riceSeed, 1);
                refreshPlots(initUIScreen, plotsBtn, waterBtns);
            }
        });

        plantPotatoBtn.setOnAction(e -> {
            Crop potatoSeed = new Crop(1, Crop.Type.Potato);
            if (farm.plant(potatoSeed, player.getInventory().get(potatoSeed))) {
                player.subtractItem(potatoSeed, 1);
                refreshPlots(initUIScreen, plotsBtn, waterBtns);
            }
        });
        refreshPlots(initUIScreen, plotsBtn, waterBtns);
        for (int i = 0; i < plotsBtn.length; i++) {
            int finalI = i;
            waterBtns[i].setOnAction(e -> {
                if (farm.getCropArray()[finalI] != null) {
                    farm.getCropArray()[finalI].water();
                    refreshPlots(initUIScreen, plotsBtn, waterBtns);
                }
            });


            plotsBtn[i].setOnAction(e -> {
                switch (plotsBtn[finalI].getText()) {
                case "Potato":
                    if (player.addItem(new Crop(7, Crop.Type.Potato), 1)) {
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        farm.setCropArray(null, finalI);
                        refreshPlots(initUIScreen, plotsBtn, waterBtns);
                    }
                    break;
                case "Corn":
                    if (player.addItem(new Crop(7, Crop.Type.Corn), 1)) {
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        farm.setCropArray(null, finalI);
                        refreshPlots(initUIScreen, plotsBtn, waterBtns);
                    }
                    break;
                case "Rice":
                    if (player.addItem(new Crop(7, Crop.Type.Rice), 1)) {
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        farm.setCropArray(null, finalI);
                        refreshPlots(initUIScreen, plotsBtn, waterBtns);
                    }
                    break;
                case "Dead Plant":
                    initUIScreen.setDirt(plotsBtn[finalI]);
                    farm.setCropArray(null, finalI);
                    refreshPlots(initUIScreen, plotsBtn, waterBtns);
                    break;
                default:
                    break;
                }
            });
            Scene scene = initUIScreen.getScene();
            mainWindow.setScene(scene);
            mainWindow.show();
        }
    }

    private void refreshPlots(InitialUIScreen initUIScreen, Button[] plotsBtn, Button[] waterBtns) {
        for (int i = 0; i < plotsBtn.length; i++) {
            if (farm.getCropArray()[i] != null) {
                initUIScreen.setPlant(plotsBtn[i], farm.getCropArray()[i]);
                initUIScreen.setWater(waterBtns[i], farm.getCropArray()[i]);
            } else {
                initUIScreen.setDirt(plotsBtn[i]);
                initUIScreen.setEmptyWater(waterBtns[i]);
            }
        }
        Scene scene = initUIScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToMarketScreen() {
        Market market = new Market(difficulty);
        HashMap<Object, Integer> stock = market.getStock();
        MarketScreen marketScreen = new MarketScreen(width, height, player, market);

        Button backBtn = marketScreen.getBackBtn();
        backBtn.setOnAction(e -> {
            goToInitialUIScreen();
        });

        for (Object key : stock.keySet()) {
            if (key instanceof Crop) {
                Crop crop = (Crop) key;
                if (crop.getSpecies().getName().equals("Potato") && crop.getStage() == 1) {
                    Button buyPotatoBtn = marketScreen.getBuyPotatoBtn();
                    buyPotatoBtn.setOnAction(e -> {
                        if (market.buy(player.getMoney(), crop, 1, player.getMaxInventorySpace()
                                - player.getInventoryCount())) {
                            player.setMoney(player.getMoney() - stock.get(crop));
                            player.addItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                    Button sellPotatoSeedBtn = marketScreen.getSellPotatoSeedBtn();
                    sellPotatoSeedBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                } else if (crop.getSpecies().getName().equals("Potato") && crop.getStage() == 3) {
                    Button sellPotatoBtn = marketScreen.getSellPotatoBtn();
                    sellPotatoBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                } else if (crop.getSpecies().getName().equals("Corn") && crop.getStage() == 1) {
                    Button buyCornBtn = marketScreen.getBuyCornBtn();
                    buyCornBtn.setOnAction(e -> {
                        if (market.buy(player.getMoney(), crop, 1, player.getMaxInventorySpace()
                                - player.getInventoryCount())) {
                            player.setMoney(player.getMoney() - stock.get(crop));
                            player.addItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                    Button sellCornSeedBtn = marketScreen.getSellCornSeedBtn();
                    sellCornSeedBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                } else if (crop.getSpecies().getName().equals("Corn") && crop.getStage() == 3) {
                    Button sellCornBtn = marketScreen.getSellCornBtn();
                    sellCornBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                } else if (crop.getSpecies().getName().equals("Rice") && crop.getStage() == 1) {
                    Button buyRiceBtn = marketScreen.getBuyRiceBtn();
                    buyRiceBtn.setOnAction(e -> {
                        if (market.buy(player.getMoney(), crop, 1, player.getMaxInventorySpace()
                                - player.getInventoryCount())) {
                            player.setMoney(player.getMoney() - stock.get(crop));
                            player.addItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                    Button sellRiceSeedBtn = marketScreen.getSellRiceSeedBtn();
                    sellRiceSeedBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                } else if (crop.getSpecies().getName().equals("Rice") && crop.getStage() == 3) {
                    Button sellRiceBtn = marketScreen.getSellRiceBtn();
                    sellRiceBtn.setOnAction(e -> {
                        if (player.getInventory().get(crop) > 0) {
                            player.setMoney(player.getMoney() + market.sell(crop, 1));
                            player.subtractItem(crop, 1);
                            mainWindow.setScene(marketScreen.getScene());
                        }
                    });
                }
            }
        }

        Scene scene = marketScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

}
