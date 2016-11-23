package v1.IHM;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import v1.Command.Command;

/**
 * Created by greg on 16/11/16.
 */
public class Cursor extends Component {

    @FXML
    private Slider cursor;

    @FXML
    public void initialize(){
        cursor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                c.execute();
            }
        });
    }

    public float getValue(){
        return (float) cursor.getValue();
    }

    public void setValue(float value){
        cursor.setValue((double) value);
    }

}
