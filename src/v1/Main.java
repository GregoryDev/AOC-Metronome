package v1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import v1.Controller.Controller;
import v1.Controller.ControllerImp;
import v1.Engine.EngineImp;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxml.load();
        primaryStage.setTitle("Metronome-v1");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();

        init(fxml);

        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public void init(FXMLLoader fxml) {
        new ControllerImp(new EngineImp(), fxml.getController());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
