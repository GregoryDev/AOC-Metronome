package v2.Command;

import v2.IHM.IhmAdapter;

public abstract class CommandAdapter {

    protected IhmAdapter adapter;

    /**
     * Initialisation de la cible
     * @param adapter la cible de la commande
     */
    public void setAdapter(IhmAdapter adapter) {
        this.adapter = adapter;
    }
}
