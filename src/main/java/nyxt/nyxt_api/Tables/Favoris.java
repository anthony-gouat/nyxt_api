package nyxt.nyxt_api.Tables;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@javax.persistence.Table(name = "favoris")
@Table
@IdClass(FavorisId.class)
public class Favoris {
    @Id
    @Column(name = "id_produit", nullable = false)
    private Long id_produit;

    @Id
    @Column(name = "id_util", nullable = false)
    private Long id_util;

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public Long getId_util() {
        return id_util;
    }

    public void setId_util(Long id_util) {
        this.id_util = id_util;
    }

    @Override
    public String toString() {
        return "Favoris{" +
                "id_produit=" + id_produit +
                ", id_util=" + id_util +
                '}';
    }
}
