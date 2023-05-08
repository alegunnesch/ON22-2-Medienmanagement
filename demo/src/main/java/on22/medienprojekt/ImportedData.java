package on22.medienprojekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImportedData {
    private static final ObservableList<String> importedDataNames = FXCollections.observableArrayList();

    public static ObservableList<String> getImportedDataNames() {
        return importedDataNames;
    }

    public static void addImportedData(String data) {
        importedDataNames.add(data);
    }
}
