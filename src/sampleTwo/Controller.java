package sampleTwo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField inputField;

    @FXML
    private TextField selectedField;

    ObservableList<String> list = FXCollections.observableArrayList(
            "Oktay", "Bakshali", "Kenan"
    );

    @FXML
    void addFunction(ActionEvent event) {
        list.add(inputField.getText());
        comboBox.setItems(list);

    }

    @FXML
    void initialize() {
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(2);

        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            selectedField.setText(newValue);
        });
    }
}
