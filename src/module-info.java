module ProjectFx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires java.sql;

    opens sample;
    opens sampleTwo;
    opens filterTable;
    opens circleMove;
}