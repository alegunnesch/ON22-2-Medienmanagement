package on22.medienprojekt;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ListView;

public class ManagementController {

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
    
    @FXML
    private ListView<String> fileList;

    public void setImportedFiles(ObservableList<String> files) {
        fileList.setItems(files);
    }

}
