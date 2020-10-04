import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ConfigController {
    //name field
    @FXML
    private TextField name;

    @FXML
    private Button nextpageBtn;

    //next button
    @FXML
    private void handleNext(ActionEvent event) throws IOException {
        Stage stage = (Stage) nextpageBtn.getScene().getWindow();
        Parent farmUI = FXMLLoader.load(getClass().getResource("initialFarmUI.fxml"));
        stage.setScene(new Scene(farmUI, 1080, 720));
        stage.show();
    }

    //name button
    @FXML
    private void handleButon(ActionEvent event) {
        System.out.println(name.getText());


    }
}

