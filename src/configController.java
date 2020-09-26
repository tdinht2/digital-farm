
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class configController {
    @FXML
    private TextField name;

    @FXML
    private void handleNext(ActionEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(new Scene(new Pane()));
    }

    @FXML
    private void handleButon(ActionEvent event) {

        System.out.println(name.getText());


    }
}

