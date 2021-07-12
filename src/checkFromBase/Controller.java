package checkFromBase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField infoField;

    @FXML
    void inFunction(ActionEvent event) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if(login.isEmpty() || password.isEmpty()){
            JOptionPane optionPane = new JOptionPane("Fill all fields", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning!");
            dialog.setVisible(true);

        } else {
            boolean checkReult = ConnectionDB.check(login, password);
            if (checkReult) System.out.println("Вы вошли");
            else System.out.println("Такого пользователя нет");
        }
    }

    @FXML
    void regFunction(ActionEvent event) {
        String login = loginField.getText();
        String password = passwordField.getText();
        ConnectionDB.insert(login, password);
    }

    @FXML
    void showInfoFunction(ActionEvent event) {
        String info = JOptionPane.showInputDialog("Enter name");
        infoField.setText(info);
    }

    @FXML
    void sureFunction(ActionEvent event) {
        int info = JOptionPane.showConfirmDialog(null,"Are you sure?",
                "Notification",JOptionPane.YES_NO_OPTION);
        System.out.println(info);
        if(info==0){
            infoField.setText("You choose Yes");
        } else {
            infoField.setText("You choose No");
        }
    }

    @FXML
    void initialize() {
        ConnectionDB.connection();

    }
}
