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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.mini.payroll.*;
import project.mini.payroll.Engineer;

import java.io.IOException;

import static javafx.scene.paint.Color.*;

public class EditEngineerController {
    Admin admin1 = new Admin();
    Engineer eng1;
    private char x;
    private Stage stage;
    private Scene scene;
    private Parent root;
    Paint paintRed = RED;
    Paint paintGreen = GREEN;
    @FXML
    private Label myLabel;

    @FXML
    private TextField myTextField;
    @FXML
    private RadioButton AgeRadio;

    @FXML
    private RadioButton GradeRadio;

    @FXML
    private RadioButton IDRadio;

    @FXML
    private RadioButton NameRadio;

    @FXML
    private Label statusLabel;

    @FXML
    private RadioButton WHoursRadio;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button submitButton;

    @FXML
    void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/EngineerScene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        new Scene(new Button("zzz"));


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
    else if(WHoursRadio.isSelected()){
        statusLabel.setVisible(false);
            myLabel.setVisible(true);
            myTextField.setVisible(true);
            submitButton.setDisable(false);
            x='h';
    }
    else if(GradeRadio.isSelected()){
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
    else  {
        statusLabel.setVisible(false);
        myLabel.setVisible(false);
            myTextField.setVisible(false);
            submitButton.setDisable(true);
          }
        }
    public void initData(Engineer eng){
            eng1 = eng;
    }
    @FXML
    void submit(ActionEvent event) {
        try { String field =  myTextField.getText();
            if (field.equalsIgnoreCase("Manager"))
                x='g';
            else if (field.equalsIgnoreCase("Team leader"))
                x='g';
            else if (field.equalsIgnoreCase("Team member"))
                x='g';
            else
               field = null;
            admin1.editEngineer(eng1.getID(), x, field);
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
        catch (WorkingHoursException e){
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
        catch (NullPointerException e){
            statusLabel.setTextFill(LIGHTCORAL);
            statusLabel.setText("Incorrect position");
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
