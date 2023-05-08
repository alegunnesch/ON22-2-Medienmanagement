package on22.medienprojekt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class ImportController {

    @FXML
    private Label label;
    
    @FXML
    private AnchorPane anchorid;
    
    @FXML
    private TextField textFieldBrowse;

    @FXML
    private ListView<String> lvFiles;

    final FileChooser fc = new FileChooser();
    List<String> importedDataNames = new ArrayList<>();

    @FXML
    private void switchToStart() throws IOException {
        App.setRoot("start");
    }
    
    @FXML
    private void switchToManagement() throws IOException {
        // Pass the list of imported file names to ManagementController
        ManagementController controller = (ManagementController) App.getController("management");
        ObservableList<String> files = FXCollections.observableArrayList(importedDataNames);
        controller.setImportedFiles(files);
        
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
    private void handleBrowseButton() throws IOException {
        fc.setTitle("Wähle Dateien aus");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files","*.*"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG","*.jpg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG","*.png"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML","*.html"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSS","*.css"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3","*.mp3"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP4","*.mp4"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TIFF","*.tiff"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MKV","*.mkv"));
        List<File> files = fc.showOpenMultipleDialog(null);

        if (files != null) {
            for (int i = 0; i < files.size(); i++){
                String fileName = files.get(i).getName();
                importedDataNames.add(fileName);
                lvFiles.getItems().add(fileName);
            }
        }
    }
    
    public List<String> getImportedDataNames() {
        return importedDataNames;
    }
}
