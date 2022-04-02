package nyxt.nyxt_api.Tables;

import java.io.Serializable;

public class FavorisId implements Serializable {
    private long id_produit;
    private long id_util;

    public FavorisId() {
    }

    public FavorisId(long id_produit, long id_util) {
        this.id_produit = id_produit;
        this.id_util = id_util;
    }
}
