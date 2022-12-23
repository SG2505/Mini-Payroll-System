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
import project.mini.payroll.Admin;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import project.mini.payroll.*;

import static javafx.scene.paint.Color.*;

public class AddEngController {

    Admin admin1 = new Admin();


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField AgeField;

    @FXML
    private TextField IDField;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField PositionField;

    @FXML
    private TextField WorkingHoursField;

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



        @FXML
  void submit (ActionEvent event){
            try{String nameText = NameTextField.getText();
            int Age = Integer.parseInt(AgeField.getText());
            int workingHours = Integer.parseInt(WorkingHoursField.getText());
            int ID = Integer.parseInt(IDField.getText());
            String grade = PositionField.getText();
            Grade grade1;
        if (grade.equalsIgnoreCase("Manager"))
            grade1 = Grade.Manager;
        else if (grade.equalsIgnoreCase("Team leader"))
            grade1 = Grade.TeamLeader;
        else if (grade.equalsIgnoreCase("Team member"))
            grade1 = Grade.TeamMember;
        else
            grade1 = null;

            admin1.addEngineer(workingHours, grade1, ID, nameText, Age);
            statusLabel.setTextFill(LIGHTGREEN);
            statusLabel.setText("Success!");
            FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        catch(WorkingHoursException whe)
            {  statusLabel.setTextFill(LIGHTCORAL);
                statusLabel.setText(whe.getMessage());
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
        catch(AgeException ae)
            {   statusLabel.setTextFill(LIGHTCORAL);
                statusLabel.setText(ae.getMessage());
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
        catch(NumberFormatException nfe)
            {statusLabel.setTextFill(LIGHTCORAL);
                statusLabel.setText("input is incorrect or missing data");
                FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
                ft.setFromValue(1.0);
                ft.setToValue(0);
                ft.setCycleCount(Timeline.INDEFINITE);
                ft.setAutoReverse(true);
                ft.play();
            }
        catch(NullPointerException npe)
            {   statusLabel.setTextFill(LIGHTCORAL);
                statusLabel.setText("incorrect position");
                FadeTransition ft = new FadeTransition(Duration.millis(1500), statusLabel);
                ft.setFromValue(1.0);
                ft.setToValue(0);
                ft.setCycleCount(Timeline.INDEFINITE);
                ft.setAutoReverse(true);
                ft.play();
            }


       // statusLabel.setText("Success!");
    }


}
