package on22.medienprojekt;

import java.io.File;
import java.io.IOException;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ImportController {

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
    private Label label;
    
        @FXML
        private AnchorPane anchorid;
        
        @FXML
        private TextField textFieldBrowse;

        @FXML
        private ListView<?> lvFiles;

    
        @FXML
        private void handleBrowseButton() throws IOException {
            final DirectoryChooser dirchooser = new DirectoryChooser();
            Stage stage = (Stage) anchorid.getScene().getWindow();
            File selectedDirectory  = dirchooser.showDialog(stage);
            if(selectedDirectory  !=null){
                System.out.println("Path: " + selectedDirectory.getAbsolutePath());
                textFieldBrowse.setText(selectedDirectory.getAbsolutePath());
            }
    }
}