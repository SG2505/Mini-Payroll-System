package Controllers;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.mini.payroll.*;

import java.io.IOException;

import static javafx.scene.paint.Color.*;

public class AddTraineeController {


    Admin admin1 = new Admin();


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField AcademicField;

    @FXML
    private TextField AgeField;

    @FXML
    private TextField GPAField;

    @FXML
    private TextField IDField;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField UniField;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Label statusLabel;

    @FXML
    private Button submitButton;

    @FXML
    void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/TraineeScene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exit(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void submit(ActionEvent event) {
        try {
        String nameText = NameTextField.getText();
        int Age = Integer.parseInt(AgeField.getText());
        int AcademicYear = Integer.parseInt(AcademicField.getText());
        int ID = Integer.parseInt(IDField.getText());
        String UniName = UniField.getText();
        double GPA = Double.parseDouble(GPAField.getText());

            admin1.addTrainee(nameText,ID,Age,UniName,GPA,AcademicYear);
            statusLabel.setTextFill(LIGHTGREEN);
            statusLabel.setText("Success!");
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (intstringexception e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (emptystringexception e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch(IDException ide)
        {   statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(ide.getMessage());
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (AgeException ae)
        {   FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
            statusLabel.setText(ae.getMessage());
            statusLabel.setTextFill(LIGHTCORAL);
        }
        catch (GPAException gpae)
        {   statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(gpae.getMessage());
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch(AcademicYearException aye)
        {   statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(aye.getMessage());
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
           }
        catch (NumberFormatException e ){
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText("Incorrect input");
        }


    }
    }



