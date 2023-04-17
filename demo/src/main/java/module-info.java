module on22.medienprojekt {
    requires javafx.controls;
    requires javafx.fxml;

    opens on22.medienprojekt to javafx.fxml;
    exports on22.medienprojekt;
}
