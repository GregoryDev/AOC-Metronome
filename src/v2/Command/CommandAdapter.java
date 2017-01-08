package v2.Command;

import v2.IHM.IhmAdapter;

public abstract class CommandAdapter {

    protected IhmAdapter adapter;

    public void setAdapter(IhmAdapter adapter) {
        this.adapter = adapter;
    }
}
