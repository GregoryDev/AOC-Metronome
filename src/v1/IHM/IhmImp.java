package v1.IHM;


/**
 * Created by greg on 23/11/16.
 */
public class IhmImp implements Ihm {

    private Cursor cursor;

    public IhmImp() {
        cursor = new Cursor();
    }

    @Override
    public void updateTempo(float tempo) {
        cursor.setValue(tempo);
    }

    @Override
    public void updateStarted(boolean started) {

    }

    @Override
    public void updateTime(int time) {

    }

    @Override
    public float getCursorPosition() { return cursor.getValue(); }
}
