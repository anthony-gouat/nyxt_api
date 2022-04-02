package nyxt.nyxt_api.Tables;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.sql.Date;

@Entity
@javax.persistence.Table(name = "utilisateur")
@Table
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_util", nullable = false)
    private Long id;

    @Column(name = "nom_util", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom_util", nullable = false, length = 50)
    private String prenom;

    @Column(name = "email_util", nullable = false, length = 100)
    private String email;

    @Column(name = "date_naissance_util")
    private Date date_naissance;

    @Lob
    @Column(name = "mot_de_passe_util", nullable = false)
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", date_naissance=" + date_naissance +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}

