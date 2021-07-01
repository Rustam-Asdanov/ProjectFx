package sample;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public AnchorPane anchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;

    @FXML
    private ImageView imageView;

    @FXML
    void initialize() {
        PieChart.Data slice1 = new PieChart.Data("Honda",15);
        PieChart.Data slice2 = new PieChart.Data("Mercedes", 20);
        PieChart.Data slice3 = new PieChart.Data("Bentley",40);

//        pieChart.getData().add(slice1);
        pieChart.getData().addAll(slice1,slice2,slice3);

        pieChart.setPrefSize(400,400);
        pieChart.setLegendSide(Side.LEFT);

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        pieData.addAll(slice1,slice2,slice3);
        applyCustomColorSequence(pieData,"red","white","black");

        pieChart.setLegendVisible(false);

//        String url = "https://snipstock.com/assets/cdn/png/7a0f6957ac9cb23095a31153ba249b2e.png";
//
//        Image image = new Image(url, true);
//
//        imageView.setImage(image);

        File file = new File("C:\\Users\\Rustam\\Desktop\\Learning programing\\Backend project\\SpringOne\\ProjectFx\\img\\img.png");

        try {
            String imageUrl = file.toURI().toURL().toString();
            Image image = new Image(imageUrl);
            imageView.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }

    private void applyCustomColorSequence(
            ObservableList<PieChart.Data> pieChartData,
            String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
            data.getNode().setStyle(
                    "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
            );
            i++;
        }
    }

    @FXML
    public void openNewWindowFunction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sampleTwo/sample.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root,500,500));
            stage.setTitle("New Window");
            stage.show();

            File file = new File("C:\\Users\\Rustam\\Desktop\\Learning programing\\Backend project\\SpringOne\\ProjectFx\\img\\online-test.png");

            String imageUrl = file.toURI().toURL().toString();
            stage.getIcons().add(new Image(imageUrl));

            ((Stage) anchorPane.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * String...pieColors
     *
     * String pieColorsOne, String...pieColorsTwo
     */
}
