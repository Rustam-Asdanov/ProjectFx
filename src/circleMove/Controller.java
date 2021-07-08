package circleMove;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle circle;

    @FXML
    void startFunction(ActionEvent event) {
        circle.requestFocus();
        circle.setOnKeyPressed((e)->{
            if(e.getCode()== KeyCode.A){
                System.out.println("key a is active");
                circle.setLayoutX(circle.getLayoutX()-5);
            } else if(e.getCode() == KeyCode.D){
                circle.setLayoutX(circle.getLayoutX()+5);
            } else if(e.getCode() == KeyCode.W){
                circle.setLayoutY(circle.getLayoutY()-5);
            }
        });
    }

    @FXML
    void initialize() {

    }
}
