module hbv7d {
    requires javafx.controls;
    requires javafx.fxml;


    exports hbv7d.ui;
    opens hbv7d.ui to javafx.fxml;
    exports hbv7d.repository;
    exports hbv7d.controller;
    exports hbv7d.model;
    //exports hbv7d;
    //opens hbv7d.ui to javafx.fxml;
    exports hbv7d.main;
    opens hbv7d.main to javafx.fxml;
}