package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.mini.payroll.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SalarySceneController {


    private Stage stage=null;
    private Scene scene;
    private Parent root;
    Engineer eng1;
    @FXML
    private Label IDlabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label PayLabel;

    @FXML
    private Label PositionLabel;

    @FXML
    private Label SalaryLabel;

    @FXML
    private Label TaxLabel;

    @FXML
    private Label WorkingLabel;


    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;



    @FXML
    void back(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("../JavaFX/EngineerScene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exit(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }
    public void initData(Engineer eng){
            eng1 =eng;
            NameLabel.setText(String.valueOf(eng1.getName()));
            IDlabel.setText(String.valueOf(eng1.getID()));
            PayLabel.setText(String.valueOf(eng1.getGrade().getPayRate()));
            PositionLabel.setText(String.valueOf(eng1.getPosition()));
            SalaryLabel.setText(String.valueOf(eng1.getSalary()));
            TaxLabel.setText(String.valueOf(eng1.getGrade().getTaxRate()));
            WorkingLabel.setText(String.valueOf(eng1.getWorkinghours()));

}






}
