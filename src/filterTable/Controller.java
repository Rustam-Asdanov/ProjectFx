package filterTable;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private TextField searchField;

    @FXML
    private TableView<Human> table;

    @FXML
    private TableColumn<Human, Integer> idColumn;

    @FXML
    private TableColumn<Human, String> nameColumn;

    @FXML
    private TableColumn<Human, String> countryColumn;

    @FXML
    private Label countLabel;

    private ObservableList<Human> humanList = FXCollections.observableArrayList(
            new Human(1,"Oktay","USA"),
            new Human(2,"Bakshali","Turkey"),
            new Human(3,"Kenan","Australia"),
            new Human(4,"Orxan","Bolivia")
    );

    private FilteredList<Human> filteredList;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Human,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Human,String>("name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<Human, String>("country"));

        table.setItems(humanList);

        filteredList = new FilteredList<>(humanList,p->true);
        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(p->p.getName().toLowerCase(Locale.ROOT).startsWith(newValue.toLowerCase(Locale.ROOT).trim()));
            table.setItems(filteredList);

            if(newValue.isEmpty()) table.setItems(humanList);
            countLabel.setText("" + filteredList.size());
        });
    }
}
