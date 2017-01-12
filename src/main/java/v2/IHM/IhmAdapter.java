package v2.IHM;

import v1.IHM.Ihm;

public interface IhmAdapter extends Ihm {

    /**
     * Lance une lecture du clavier passif et
     * declenche des commandes en fonction
     */
    void read();
}
