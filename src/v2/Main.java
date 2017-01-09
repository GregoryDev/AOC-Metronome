package v2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.Command.Command;
import shared.Controller.ControllerImp;
import shared.Engine.EngineImp;
import v2.Clock.Clock;
import v2.Clock.ClockImp;
import v2.Command.CommandAdapter;
import v2.Command.Read;

public class Main extends Application {

    /**
     * Initialisation JavaFX
     * @param primaryStage l'objet Stage de JavaFX
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxml.load();
        primaryStage.setTitle("Metronome-v2");
        Scene scene = new Scene(root, 600, 300);
        scene.getRoot().requestFocus();
        primaryStage.setScene(scene);
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
        Clock clock = new ClockImp();
        Command read = new Read();
        ((CommandAdapter)read).setAdapter(fxml.getController());
        clock.setCommand(read);
        (new Thread(clock)).start();
    }

    /**
     * Le Main de la version 2 du metronome
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
