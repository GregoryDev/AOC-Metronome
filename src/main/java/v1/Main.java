package v1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import v1.Controller.ControllerImp;
import shared.Engine.EngineImp;

public class Main extends Application {

    /**
     * Initialisation JavaFX
     * @param primaryStage l'objet Stage de JavaFX
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/sampleV1.fxml"));
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

    /**
     * Instantiation et initialisation du controller, de l'engine et de l'ihm
     * @param fxml le loader de JavaFX
     */
    public void init(FXMLLoader fxml) {
        new ControllerImp(new EngineImp(), fxml.getController());
    }

    /**
     * Le Main de la version 1 du metronome
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
