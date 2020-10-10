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

public class InitialUIScreen {
    private int width;
    private int height;
    private int money;
    private int day;
    private Button[] plotsBtn = new Button[10];

    private InitialUIScreen() { }
    public InitialUIScreen(int w, int h, int m, int d) {
        width = w;
        height = h;
        money = m;
        day = d;
    }

    public Scene getScene() {
        HBox plotRow1 = new HBox();
        HBox plotRow2 = new HBox();
        Text moneyText = new Text("Money: " + money);
        moneyText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Text dayText = new Text("Day: " + day);
        dayText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 30));
        Image dirt = new Image("dirt_plot.png");
        Image cornSeed = new Image("seed_plot.png");
        Image potatoSeed = new Image("seed_plot.png");
        Image riceSeed = new Image("seed_plot.png");
        Image immatureCorn = new Image("immature_corn.png");
        Image immaturePotato = new Image("immature_potato.png");
        Image immatureRice = new Image("immature_rice.png");
        Image corn = new Image("corn_plot.png");
        Image potato = new Image("potato_plot.png");
        Image rice = new Image("rice_plot.png");


        //Create plots
        ImageView[] plots = new ImageView[10];
        for (int i = 0; i < 10; i++) {
            plotsBtn[i] = new Button();
            int randomVal = (int) (Math.random() * 9);
            switch(randomVal) {
                case 0:
                    plots[i] = new ImageView(cornSeed);
                    plotsBtn[i].setText("Corn Seed");
                    break;
                case 1:
                    plots[i] = new ImageView(potatoSeed);
                    plotsBtn[i].setText("Potato Seed");
                    break;
                case 2:
                    plots[i] = new ImageView(riceSeed);
                    plotsBtn[i].setText("Rice Seed");
                    break;
                case 3:
                    plots[i] = new ImageView(immatureCorn);
                    plotsBtn[i].setText("Immature Corn");
                    break;
                case 4:
                    plots[i] = new ImageView(immaturePotato);
                    plotsBtn[i].setText("Immature Potato");
                    break;
                case 5:
                    plots[i] = new ImageView(immatureRice);
                    plotsBtn[i].setText("Immature Rice");
                    break;
                case 6:
                    plots[i] = new ImageView(corn);
                    plotsBtn[i].setText("Corn");
                    break;
                case 7:
                    plots[i] = new ImageView(potato);
                    plotsBtn[i].setText("Potato");
                    break;
                case 8:
                    plots[i] = new ImageView(rice);
                    plotsBtn[i].setText("Rice");
                    break;
            }
            plots[i].setFitHeight(210);
            plots[i].setFitWidth(200);
            plotsBtn[i].setGraphic(plots[i]);
            plotsBtn[i].setTextOverrun(OverrunStyle.CLIP);
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

        VBox initialFarm = new VBox(moneyText, dayText, plotRow1, plotRow2);
        return new Scene(initialFarm, width, height);
    }
}
