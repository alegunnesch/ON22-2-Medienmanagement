package on22.medienprojekt;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
//import javafx.stage.Stage;

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
        private ListView<File> lvFiles;


        final FileChooser fc = new FileChooser();
    
        @FXML
        private void handleBrowseButton() throws IOException {
            //final DirectoryChooser dirchooser = new DirectoryChooser();
            //Stage stage = (Stage) anchorid.getScene().getWindow();
            //File selectedDirectory  = dirchooser.showDialog(stage);
            //if(selectedDirectory  !=null){
            //    System.out.println("Path: " + selectedDirectory.getAbsolutePath());
            //    textFieldBrowse.setText(selectedDirectory.getAbsolutePath());
            //}


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

            for (int i = 0; i < files.size(); i++){
                if (files != null) {
                    System.out.println("test");
                    lvFiles.getItems().add(files.get(i));
                }
                //textFieldBrowse.appendText(files.get(i).getAbsolutePath()+ "\n");
            }
           

    }
}