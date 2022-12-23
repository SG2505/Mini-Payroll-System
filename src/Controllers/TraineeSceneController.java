package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import project.mini.payroll.Admin;
import project.mini.payroll.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TraineeSceneController implements Initializable {


    Admin admin1 = new Admin();

    Trainee trn = new Trainee();

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Trainee, Integer> AcademicColumn;

    @FXML
    private TableColumn<Employee,Integer> AgeColumn;

    @FXML
    private TableColumn<Trainee, String> HowCoulmn;
    @FXML
    private TableColumn<Trainee, Double> GPAcolumn;

    @FXML
    private TableColumn<Employee,Integer> IDcolumn;

    @FXML
    private TableColumn<Employee,String> NameColumn;

    @FXML
    private TableColumn<Trainee, Integer> SalaryColumn;

    @FXML
    private TableView<Trainee> TraineTable;

    @FXML
    private TableColumn<Trainee,String> UniColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    void addTrainee(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/AddTrainee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void back(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../JavaFX/AdminScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteTrainee(ActionEvent event) {

        TraineTable.getItems().removeAll(TraineTable.getSelectionModel().getSelectedItem());
        admin1.deleteTrainee(trn.getID());

    }

    @FXML
    void editTrainee(ActionEvent event) throws IOException {

        Trainee trn1 =TraineTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../JavaFX/EditTraineeScene.fxml"));
        Parent root = loader.load();
        EditTraineeController controller =loader.getController();
        controller.initData(trn1);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
       /* TraineTable.setEditable(true);
        NameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Employee,String> event) {
                Employee emp = event.getRowValue();
                admin1.editTrainee(emp.getID(),'n',event.getNewValue());
            }

        });

        AgeColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Age"));
        AgeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        AgeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Employee,Integer> event) {
                Employee emp = event.getRowValue();
                admin1.editTrainee(emp.getID(),'a',Integer.toString(event.getNewValue()));
            }

        });

        IDcolumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
        IDcolumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        IDcolumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Employee,Integer> event) {
                Employee emp = event.getRowValue();
                admin1.editTrainee(emp.getID(),'i',Integer.toString(event.getNewValue()));
            }

        });

        GPAcolumn.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("GPA"));
        GPAcolumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        GPAcolumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Trainee, Double>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Trainee,Double> event) {
                Trainee trn = event.getRowValue();
                admin1.editTrainee(trn.getID(),'g',Double.toString(event.getNewValue()));
            }

        });

        UniColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("UniName"));
        UniColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        UniColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Trainee, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Trainee,String> event) {
                Trainee trn = event.getRowValue();
                admin1.editTrainee(trn.getID(),'u',event.getNewValue());
            }

        });
        AcademicColumn.setCellValueFactory(new PropertyValueFactory<Trainee, Integer>("AcademicYear"));
        AcademicColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        AcademicColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Trainee, Integer>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Trainee,Integer> event) {
                Trainee trn = event.getRowValue();
                admin1.editTrainee(trn.getID(),'y',Integer.toString(event.getNewValue()));
            }

        });*/

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

    ObservableList<Trainee> traineesList = FXCollections.observableList(admin1.viewTrainee());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        IDcolumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("ID"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("Age"));
        UniColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("UniName"));
        AcademicColumn.setCellValueFactory(new PropertyValueFactory<Trainee,Integer>("AcademicYear"));
        GPAcolumn.setCellValueFactory(new PropertyValueFactory<Trainee,Double>("GPA"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<Trainee,Integer>("Salary"));

        TraineTable.setItems(traineesList);

    }
    public void getSelected (MouseEvent event){
        trn =TraineTable.getSelectionModel().getSelectedItem();
        editButton.setDisable(false);
        deleteButton.setDisable(false);


    }
}
