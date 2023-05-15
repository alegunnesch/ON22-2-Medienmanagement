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
import javafx.scene.control.cell.ComboBoxListCell;

import java.io.Console;
import java.io.FileInputStream;

import java.io.ObjectInputStream;
import java.util.List;

public class ManagementController implements Initializable {

    @FXML
    private ListView<String> lvImportedFiles;
    private ObservableList<String> data;
    private ObservableList<String> dateien;

    @FXML
    private TreeView<String> treeView;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        dateien = FXCollections.observableArrayList(
                "Datei1", "Datei2", "Datei3", "Datei4"
        );

        data = FXCollections.observableArrayList();
        for (int i = 0; i < 4; i++) {
            data.add(dateien.get(i % dateien.size())); // add a name to the list view for each iteration
        }

        lvImportedFiles.setItems(data);
        lvImportedFiles.setCellFactory(ComboBoxListCell.forListView(dateien));

        TreeItem<String> rootItem = new TreeItem<>("Root");

        TreeItem<String> branchItem1 = new TreeItem<>("Folder 1");
        TreeItem<String> branchItem2 = new TreeItem<>("file.css");
        TreeItem<String> branchItem3 = new TreeItem<>("file.js");

        TreeItem<String> twigItem1 = new TreeItem<>("Folder 2");
        TreeItem<String> twigItem2 = new TreeItem<>("file.html");

        TreeItem<String> leafItem1 = new TreeItem<>("file1.xml");
        TreeItem<String> leafItem2 = new TreeItem<>("file2.xml");
        TreeItem<String> leafItem3 = new TreeItem<>("file3.xml");

        twigItem1.getChildren().addAll(leafItem1, leafItem2, leafItem3);

        branchItem1.getChildren().addAll(twigItem1, twigItem2);

        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        treeView.setRoot(rootItem);
    }

    public void selectItem() {
        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            System.out.println(selectedItem.getValue());
        }
    }

    @FXML
public void extractNamesFromTagFile() {
    try (FileInputStream fis = new FileInputStream("lvFiles");
     ObjectInputStream ois = new ObjectInputStream(fis)) {

        List<String> fileNames = (List<String>) ois.readObject();

        data = FXCollections.observableArrayList(fileNames);
        lvImportedFiles.setItems(data);
} catch (IOException | ClassNotFoundException e) {
    System.out.println("Error while reading data from lvFiles: " + e.getMessage());
    e.printStackTrace();
}

}
}

