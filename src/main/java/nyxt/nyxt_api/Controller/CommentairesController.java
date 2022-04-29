package nyxt.nyxt_api.Controller;

import nyxt.nyxt_api.Repository.CommentairesRepositiry;
import nyxt.nyxt_api.Repository.CommentairesRepositiry;
import nyxt.nyxt_api.Repository.ProduitRepositiry;
import nyxt.nyxt_api.Tables.Commentaires;
import nyxt.nyxt_api.Tables.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentairesController {

    @Autowired
    private CommentairesRepositiry commentairesRepositiry;

    @GetMapping
    public List<Commentaires> findAllCommentaires() {
        return (List<Commentaires>) commentairesRepositiry.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaires> findCommentairesById(@PathVariable(value = "id") long id) {
        Optional<Commentaires> commentaire = commentairesRepositiry.findById(id);

        if (commentaire.isPresent()) {
            return ResponseEntity.ok().body(commentaire.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/produit/{id}")
    public List<Commentaires> findCommentairesByProduit(@PathVariable(value = "id") long id) {
        List<Commentaires> commentaires = (List<Commentaires>) commentairesRepositiry.findAll();
        List<Commentaires> res = new ArrayList<Commentaires>();
        for (Commentaires commentaire:commentaires) {
            if(commentaire.getId_produit()==id)res.add(commentaire);
        }
        return res;
    }

    @PostMapping
    public Commentaires saveCommentaires(@Validated @RequestBody Commentaires commentaire) {
        return commentairesRepositiry.save(commentaire);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentaires(@PathVariable(value = "id") long id) {
        commentairesRepositiry.deleteById(id);
    }

    @PutMapping("/{id}")
    public Commentaires updateCommentaires(@Validated @RequestBody Commentaires commentaire, @PathVariable(value = "id") Long id) {
        Optional<Commentaires> commentairebyId = commentairesRepositiry.findById(id);
        Commentaires commentaire1 = null;
        if (commentairebyId.isPresent()) {
            commentaire1 = commentairebyId.get();
            if (commentaire.getId_produit() > 0) commentaire1.setId_produit(commentaire.getId_produit());
            if (commentaire.getId_utilisateur() > 0) commentaire1.setId_utilisateur(commentaire.getId_utilisateur());
            if (commentaire.getTexte() != null) commentaire1.setTexte(commentaire.getTexte());
            if (commentaire.getNote() >= 0) commentaire1.setNote(commentaire.getNote());
            return commentairesRepositiry.save(commentaire1);
        }
        return null;
    }
}
