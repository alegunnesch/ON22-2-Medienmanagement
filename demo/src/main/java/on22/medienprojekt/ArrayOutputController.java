package on22.medienprojekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ArrayOutputController {

    @FXML
    private ListView<String> ArrayOutput;

    public void initialize() {
        String[] items = {"Item 1", "Item 2", "Item 3"};

        ObservableList<String> observableList = FXCollections.observableArrayList(items);
        ArrayOutput.setItems(observableList);
        
    }




}