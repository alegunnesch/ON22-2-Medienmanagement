package on22.medienprojekt;

import java.io.IOException;
import javafx.fxml.FXML;

public class TaglistController {
    
    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }
    @FXML
    private void switchToManagement() throws IOException {
        App.setRoot("management");
    }
    @FXML
    private void switchToTaglist() throws IOException {
        App.setRoot("taglist");
    }
    @FXML
    private void switchToImport() throws IOException {
        App.setRoot("import");
    }
}


