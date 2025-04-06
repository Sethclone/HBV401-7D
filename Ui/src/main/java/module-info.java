module hbv7d.ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens hbv7d.ui to javafx.fxml;
    exports hbv7d.ui;
}