package on22.medienprojekt;

import java.io.IOException;
import javafx.fxml.FXML;

public class ImportController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToTagliste() throws IOException {
        App.setRoot("tagliste");
    }
    @FXML
    private void switchToImport() throws IOException {
        App.setRoot("import");
    }
}