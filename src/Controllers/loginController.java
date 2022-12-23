package Controllers;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import project.mini.payroll.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.LIGHTCORAL;
import static javafx.scene.paint.Color.RED;

public class loginController implements Initializable {


    private String username;
    private String password;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button exitButton;
    @FXML
    private ImageView myImage = new ImageView();
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameTextField;
    @FXML
    private Label statusLabel;


    @FXML
    public void submit(ActionEvent event) throws IOException {
        username = usernameTextField.getText();
        password = passwordTextField.getText();

        if (Admin.getUsername().equals(username) && Admin.getPassword().equals(password)) {

            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/AdminScene.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
        else{
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText("Wrong Combinations of\nUsername and Password");
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();


        }

    }

    @FXML

    public void exit(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");


        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("../JavaFx/PinClipart.com_sold-clip-art_1673655.png"));
        myImage.setImage(image);
    }
}
