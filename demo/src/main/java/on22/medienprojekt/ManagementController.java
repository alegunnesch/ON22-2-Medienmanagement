package on22.medienprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ListView;

public class ManagementController implements Initializable {

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

    @FXML
    private TreeView treeView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
       TreeItem<String> rootItem = new TreeItem<>("Root");

       TreeItem<String> branchItem1 = new TreeItem<>("Folder 1");
       TreeItem<String> branchItem2 = new TreeItem<>("file.css");
       TreeItem<String> branchItem3 = new TreeItem<>("file.js");

       TreeItem<String> twigItem1 = new TreeItem<>("Folder 2");
       TreeItem<String> twigItem2 = new TreeItem<>("file.html");
       
       TreeItem<String> leafItem1 = new TreeItem<>("file1.xml");
       TreeItem<String> leafItem2 = new TreeItem<>("file2.xml");
       TreeItem<String> leafItem3 = new TreeItem<>("file3.xml");
       
       
       twigItem1.getChildren().addAll(leafItem1,leafItem2, leafItem3);

       branchItem1.getChildren().addAll(twigItem1,twigItem2);
           
       rootItem.getChildren().addAll(branchItem1,branchItem2,branchItem3);

       treeView.setRoot(rootItem);
    }

    public void selectItem() {
        TreeItem<String> selectedItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
        
        if(selectedItem != null) {
            System.out.println(selectedItem.getValue());
        }
     }
    }     
