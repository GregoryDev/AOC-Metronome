package v2.Command;

import v2.IHM.IhmAdapterImpl;

public abstract class CommandAdapter {

    protected IhmAdapterImpl adapter;

    public void setAdapter(IhmAdapterImpl adapter) {
        this.adapter = adapter;
    }
}
