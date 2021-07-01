package sampleTwo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.ConnectionDB;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField manField;

    @FXML
    private TextField girlField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ListView<String> oglanEvi;

    @FXML
    private ListView<String> qizEvi;

    ObservableList<Friends> friends = FXCollections.observableArrayList();
    ObservableList<String> comboList = FXCollections.observableArrayList();
    ObservableList<String> boyList = FXCollections.observableArrayList();
    ObservableList<String> girlList = FXCollections.observableArrayList();


    @FXML
    void addFunction(ActionEvent event) {
        Friends friends = new Friends(nameField.getText(),surnameField.getText(),
                manField.getText(),girlField.getText());
        ConnectionDB.insert(friends);
        refresh();
    }

    @FXML
    void deleteFunction(ActionEvent event) {

    }

    static String importantName = "";
    @FXML
    void initialize() {
        ConnectionDB.connection();
        refresh();
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> {
            boyList.clear();
            girlList.clear();
            String name = newValue.split(" ")[0];
            String surname = newValue.split(" ")[1];
            String friend_boy = "";
            String friend_girl = "";
            for(Friends f : friends){
                if(f.getName().equals(name) && f.getSurname().equals(surname)){
                    friend_boy = f.getFriend_boy();
                    friend_girl = f.getFriend_girl();
                }
            }

            boyList.add(friend_boy);
            girlList.add(friend_girl);

            oglanEvi.setItems(boyList);
            qizEvi.setItems(girlList);



            // fill all text fields
            importantName = name;
            nameField.setText(name);
            surnameField.setText(surname);
            manField.setText(friend_boy);
            girlField.setText(friend_girl);
        });

    }

    public void refresh(){
        friends = ConnectionDB.getHumans();
        comboList.clear();
        for(Friends f: friends){
            comboList.add(f.getName()+" "+f.getSurname());
        }
        comboBox.setItems(comboList);
    }

    @FXML
    public void updateFunction(ActionEvent actionEvent) {

        Friends friends = new Friends(
                nameField.getText(), surnameField.getText(),
                manField.getText(),girlField.getText()
        );

        ConnectionDB.update(friends,importantName);

        refresh();
    }
}
