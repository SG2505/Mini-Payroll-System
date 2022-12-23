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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.mini.payroll.*;

import java.io.IOException;

import static javafx.scene.paint.Color.*;

public class EditTraineeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    char x;
    Trainee trn1;
    Admin admin1 = new Admin();
    Paint paintRed = LIGHTGREEN;
    Paint paintGreen = GREEN;
    @FXML
    private RadioButton AgeRadio;

    @FXML
    private RadioButton GPARadio;

    @FXML
    private RadioButton AcademicYearButton;

    @FXML
    private RadioButton IDRadio;

    @FXML
    private RadioButton NameRadio;

    @FXML
    private RadioButton UniNameRadio;

    @FXML
    private Button backButton;

    @FXML
    private ToggleGroup edit;

    @FXML
    private Button exitButton;

    @FXML
    private Label myLabel;

    @FXML
    private TextField myTextField;
    @FXML
    private Label statusLabel;

    @FXML
    private AnchorPane scenePane;

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

    @FXML
    void radio(ActionEvent event) {
        if(NameRadio.isSelected())
        {   statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='n';}
        else if(AgeRadio.isSelected()){
            statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='a';
        }
        else if(UniNameRadio.isSelected()){
            statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='u';
        }
        else if(GPARadio.isSelected()){
            statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='g';
        }
        else if (IDRadio.isSelected()){
            statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='i';
        }
        else if (AcademicYearButton.isSelected()){
            statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='y';
        }
        else  {
            statusLabel.setVisible(false);
            myLabel.setVisible(false);
            myTextField.setVisible(false);
            submitButton.setDisable(true);
        }
    }
    public void initData(Trainee trn){
        trn1 = trn;
    }

    @FXML
    void submit(ActionEvent event) {
        try {
            admin1.editTrainee(trn1.getID(), x, myTextField.getText());
            statusLabel.setTextFill(LIGHTGREEN);
            statusLabel.setText("Success!");
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (NumberFormatException nfe){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText("Wrong Input!");
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (emptystringexception ese){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(ese.getMessage());
            statusLabel.setVisible(true);
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
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (IDException e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (GPAException e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch (AgeException e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch(AcademicYearException e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText(e.getMessage());
            statusLabel.setVisible(true);
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }

    }

    }


