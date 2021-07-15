package table_Date;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<TableClass> table;

    @FXML
    private TableColumn<TableClass, Integer> idColumn;

    @FXML
    private TableColumn<TableClass, String> humanColumn;

    @FXML
    private TableColumn<TableClass, Date> birthdayColumn;

    @FXML
    private TextField nameFiled;

    @FXML
    private DatePicker birthdayField;

    @FXML
    private Button addButton;

    ObservableList<TableClass> tableList = FXCollections.observableArrayList();

    @FXML
    void addFunction(ActionEvent event) {
        String name = nameFiled.getText();
        LocalDate birthday = birthdayField.getValue();
        ConnectionTable.insert(name,birthday);
        showTableDate();
    }

    @FXML
    void initialize() {
        ConnectionTable.connection();

        idColumn.setCellValueFactory(new PropertyValueFactory<TableClass,Integer>("id"));
        humanColumn.setCellValueFactory(new PropertyValueFactory<TableClass, String>("human"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<TableClass, Date>("birthday"));

        showTableDate();

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            nameFiled.setText(newValue.getHuman());
            birthdayField.setValue(LocalDate.parse("" + newValue.getBirthday()));
        });

        addButton.setStyle("-fx-background-color: red");
    }

    public void showTableDate(){
        tableList = ConnectionTable.getData();
        table.setItems(tableList);
    }
}
