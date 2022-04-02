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

}
