package v1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import v1.Controller.Controller;
import v1.Controller.ControllerImp;
import v1.Engine.Engine;
import v1.Engine.EngineImp;
import v1.IHM.Ihm;
import v1.IHM.IhmImp;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxml.load();
        primaryStage.setTitle("Metronome");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();

        init(fxml);
    }

    public void init(FXMLLoader fxml) {
        Controller controller = new ControllerImp(new EngineImp(), fxml.getController());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
