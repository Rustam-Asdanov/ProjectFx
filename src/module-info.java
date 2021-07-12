module ProjectFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires java.sql;
    requires javafx.swing;

    opens sample;
    opens sampleTwo;
    opens filterTable;
    opens circleMove;
    opens checkFromBase;
}