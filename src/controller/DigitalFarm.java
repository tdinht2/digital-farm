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

public class DigitalFarm extends Application {
    private Stage mainWindow;
    private Player player;
    private Farm farm;
    private final int width = 1080;
    private final int height = 720;
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
            startCrop = new Crop(Crop.Type.Rice);
        });

        Button cornBtn = configScreen.getCornBtn();
        cornBtn.setOnAction(e -> {
            startCrop = new Crop(Crop.Type.Corn);
        });

        Button potatoBtn = configScreen.getPotatoBtn();
        potatoBtn.setOnAction(e -> {
            startCrop = new Crop(Crop.Type.Potato);
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
            //unfinished, account for season and seed
            if (inputName != null && !inputName.trim().equals("") && difficulty != 0) {
                player = new Player(inputName, 0, difficulty);
                player.addItem(startCrop, 1);
                farm = new Farm(difficulty);
                goToInitialUIScreen();
            }
        });

        Scene scene = configScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private Crop randomCrop() {
        return new Crop(startCrop.getSpecies());
    }
    private void goToInitialUIScreen() {
        InitialUIScreen initUIScreen = new InitialUIScreen(width, height, player.getMoney(),
                farm.getDay(), player.getInventory());

        Button marketBtn = initUIScreen.getMarketBtn();
        marketBtn.setOnAction(e -> {
            goToMarketScreen();
        });
        Button[] plotsBtn = initUIScreen.getPlotsBtn();
        for (int i = 0; i < plotsBtn.length; i++) {
            plotsBtn[i] = new Button();
            initUIScreen.setPlant(plotsBtn[i], randomCrop());
        }
        for (int i = 0; i < plotsBtn.length; i++) {
            int finalI = i;
            plotsBtn[i].setOnAction(e -> {
                switch (plotsBtn[finalI].getText()) {
                    case "Potato":
                        player.addItem(new Crop(3, Crop.Type.Potato), 1);
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        break;
                    case "Corn":
                        player.addItem(new Crop(3, Crop.Type.Corn), 1);
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        break;
                    case "Rice":
                        player.addItem(new Crop(3, Crop.Type.Rice), 1);
                        initUIScreen.setDirt(plotsBtn[finalI]);
                        break;
                }

            });
            Scene scene = initUIScreen.getScene();
            mainWindow.setScene(scene);
            mainWindow.show();
        }
    }

    private void goToMarketScreen() {
        Market market = new Market(difficulty);
        MarketScreen marketScreen = new MarketScreen(width, height, player, market);

        Scene scene = marketScreen.getScene();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

}
