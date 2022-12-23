package Controllers;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import project.mini.payroll.*;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EngineerScene1Controller implements Initializable {

    Admin admin1 = new Admin();
    Engineer eng;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Engineer> tableView;
    @FXML
    private TableColumn<Employee, Integer> Age;
    @FXML
    private TableColumn<Employee, Integer> ID;
    @FXML
    private TableColumn<Employee, String> Name;
    @FXML
    private TableColumn<Engineer, String> Position;
    @FXML
    private TableColumn<Engineer, Integer> WorkingHours;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;
    @FXML
    private Button calacSalaryButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane scenePane;

    ObservableList<Engineer> engineersList = FXCollections.observableList(admin1.viewEngineer());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        Name.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        ID.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("ID"));
        Age.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("Age"));
       Position.setCellValueFactory(new PropertyValueFactory<Engineer, String>("Position"));
       WorkingHours.setCellValueFactory(new PropertyValueFactory<Engineer,Integer>("Workinghours"));
        tableView.setItems(engineersList);
    }
    @FXML
    void addEngineer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/AddEng.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/AdminScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void calculate(ActionEvent event) throws IOException {


        Engineer eng1 =tableView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../JavaFX/SalaryScene.fxml"));
        Parent root = loader.load();
        SalarySceneController controller =loader.getController();
        controller.initData(eng1);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void delete(ActionEvent event) {

          tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
          admin1.deleteEngineer(eng.getID());

    }

    @FXML
    void edit(ActionEvent event) throws IOException{

        Engineer eng1 =tableView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../JavaFX/EditEngineerScene.fxml"));
        Parent root = loader.load();
        EditEngineerController controller =loader.getController();
        controller.initData(eng1);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
        /*try {
            tableView.setEditable(true);

            Name.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
            Name.setCellFactory(TextFieldTableCell.forTableColumn());
            Name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Employee, String> event) {
                    Employee emp = event.getRowValue();
                    admin1.editEngineer(emp.getID(), 'n', event.getNewValue());
                }

            });
try{
            Age.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Age"));
            Age.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));}
catch (NumberFormatException nfe){
    System.out.println(nfe.getMessage());
}
            Age.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Employee, Integer> event) {
                    Employee emp = event.getRowValue();

                    admin1.editEngineer(emp.getID(), 'a', Integer.toString(event.getNewValue()));
                }
            }




            );


            ID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
            ID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            ID.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Integer>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Employee, Integer> event) {
                    Employee emp = event.getRowValue();
                    admin1.editEngineer(emp.getID(), 'i', Integer.toString(event.getNewValue()));
                }

            });

            WorkingHours.setCellValueFactory(new PropertyValueFactory<Engineer, Integer>("Workinghours"));
            WorkingHours.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            WorkingHours.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Engineer, Integer>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Engineer, Integer> event) {
                    Engineer eng = event.getRowValue();

                    admin1.editEngineer(eng.getID(), 'h', Integer.toString(event.getNewValue()));
                    System.out.println("Error");
                }

            });

            Position.setCellValueFactory(new PropertyValueFactory<Engineer, String>("Position"));
            Position.setCellFactory(TextFieldTableCell.forTableColumn());
            Position.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Engineer, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Engineer, String> event) {
                    Engineer eng = event.getRowValue();
                    admin1.editEngineer(eng.getID(), 'g', event.getNewValue());
                }

            });
        }
        catch(Exception nfe ){
            System.out.println("Input is in correct");
        }*/
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

    public void getSelected(MouseEvent event){
        eng =tableView.getSelectionModel().getSelectedItem();
        editButton.setDisable(false);
        deleteButton.setDisable(false);
        calacSalaryButton.setDisable(false);

    }
}
