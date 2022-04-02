package nyxt.nyxt_api.Tables;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@javax.persistence.Table(name = "produit")
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produit", nullable = false)
    private Long id;

    @Column(name = "nom_produit", nullable = false, length = 100)
    private String nom;

    @Lob
    @Column(name = "description_produit")
    private String description;

    @Column(name = "type_produit", length = 100)
    private String type;

    @Column(name = "score")
    private int score;

    @Column(name = "prix")
    private float prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", score=" + score +
                ", prix=" + prix +
                '}';
    }
}

