package nyxt.nyxt_api.Tables;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@javax.persistence.Table(name = "commentaires")
@Table
public class Commentaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentaire", nullable = false)
    private Long id;

    @Column(name = "id_produit", nullable = false)
    private Long id_produit;

    @Column(name = "id_utilisateur", nullable = false)
    private Long id_utilisateur;

    @Lob
    @Column(name = "texte")
    private String texte;

    @Column(name = "note")
    private int note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Commentaires{" +
                "id=" + id +
                ", id_produit=" + id_produit +
                ", id_utilisateur=" + id_utilisateur +
                ", texte='" + texte + '\'' +
                ", note=" + note +
                '}';
    }
}

