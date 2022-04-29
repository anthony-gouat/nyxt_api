package nyxt.nyxt_api.Controller;

import nyxt.nyxt_api.Repository.ProduitRepositiry;
import nyxt.nyxt_api.Tables.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {

    @Autowired
    private ProduitRepositiry produitRepositiry;

    @GetMapping
    public List<Produit> findAllProduits() {
        return (List<Produit>) produitRepositiry.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> findProduitById(@PathVariable(value = "id") long id) {
        Optional<Produit> produit = produitRepositiry.findById(id);

        if (produit.isPresent()) {
            return ResponseEntity.ok().body(produit.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Produit saveProduit(@Validated @RequestBody Produit produit) {
        return produitRepositiry.save(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable(value = "id") long id) {
        produitRepositiry.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@Validated @RequestBody Produit produit, @PathVariable(value = "id") Long id) {
        Optional<Produit> produitbyId = produitRepositiry.findById(id);
        Produit produit1 = null;
        if (produitbyId.isPresent()) {
            produit1 = produitbyId.get();
            if (produit.getNom() != null) produit1.setNom(produit.getNom());
            if (produit.getDescription() != null) produit1.setDescription(produit.getDescription());
            if (produit.getType() != null) produit1.setType(produit.getType());
            if (produit.getScore() >= 0) produit1.setScore(produit.getScore());
            if (produit.getPrix() >= 0.0) produit1.setPrix(produit.getPrix());
            return produitRepositiry.save(produit1);
        }
        return null;
    }
}
