package on22.medienprojekt;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    // Das ist ein Comment zum Testen
    //Nochmal was geändert
}