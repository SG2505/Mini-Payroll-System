package Controllers;

import project.mini.payroll.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.Parent;

public class Main extends Application  {

    public static void main(String[]args) throws Exception{
        Admin admin1 = new Admin();
        try{
            admin1.addEngineer(160, Grade.TeamLeader, 20031, "Etsh", 25);
            admin1.addEngineer(160, Grade.TeamLeader, 2002, "Sala", 29);
            admin1.addEngineer(150, Grade.TeamMember, 2003, "Ziecho", 30);
            admin1.addEngineer(150, Grade.Manager, 2086, "Seif", 27);
            admin1.addEngineer(150, Grade.Manager, 2112, "Nagy", 28);
            admin1.addTrainee("Morgan", 12345, 18, "AUC", 3.2, 3);
            admin1.addTrainee("Hadras", 54321, 19, "ASU", 3.4, 4);}
        catch (AgeException ae)
        {
            System.out.println(ae);
        }
        catch(WorkingHoursException whe)
        {
            System.out.println(whe);
        }
        catch(IDException IDE)
        {
            System.out.println(IDE);
        }
        catch(GPAException GPAE)
        {
            System.out.println(GPAE);
        }
        catch(AcademicYearException AYE)
        {
            System.out.println(AYE);
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/loginScreen.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("Mini Payroll");
            stage.setResizable(false);
           Image icon = new Image("JavaFX/man-in-suit-silhouette-vector-36.jpg");
            stage.getIcons().add(icon);
            scene.getStylesheets().add(getClass().getResource("../JavaFx/styleSheet.css").toExternalForm());


            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
