package on22.medienprojekt;

import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ComboBoxListCell;

public class TaglistController {
    @FXML
    private ListView<String> listView;

    private ObservableList<String> data;
    private ObservableList<String> names;

    public void initialize() {

        names = FXCollections.observableArrayList(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        );

        data = FXCollections.observableArrayList();
        for (int i = 0; i < 18; i++) {
            data.add(names.get(i % names.size())); // add a name to the list view for each iteration
        }

        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));
    }

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
    public void addItem() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Tag hinzufügen");
        dialog.setHeaderText(null);
        dialog.setContentText("Bitte geben Sie den neuen Tag ein:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(tag -> {
            listView.getItems().add(tag);
        });
    }

    @FXML
    public void removeItem() {
        ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
        listView.getItems().removeAll(selectedItems);
    }
}
