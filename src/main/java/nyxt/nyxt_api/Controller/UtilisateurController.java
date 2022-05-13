package nyxt.nyxt_api.Controller;

import nyxt.nyxt_api.Repository.UtilisateurRepositiry;
import nyxt.nyxt_api.Repository.UtilisateurRepositiry;
import nyxt.nyxt_api.Tables.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepositiry utilisateurRepositiry;

    @GetMapping
    public List<Utilisateur> findAllUtilisateurs() {
        return (List<Utilisateur>) utilisateurRepositiry.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable(value = "id") long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepositiry.findById(id);

        if (utilisateur.isPresent()) {
            return ResponseEntity.ok().body(utilisateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Utilisateur saveUtilisateur(@Validated @RequestBody Utilisateur utilisateur) {
        return utilisateurRepositiry.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable(value = "id") long id) {
        utilisateurRepositiry.deleteById(id);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@Validated @RequestBody Utilisateur utilisateur, @PathVariable(value = "id") Long id) {
        Optional<Utilisateur> utilisateurbyId = utilisateurRepositiry.findById(id);
        Utilisateur utilisateur1 = null;
        if (utilisateurbyId.isPresent()) {
            utilisateur1 = utilisateurbyId.get();
            if (utilisateur.getNom() != null) utilisateur1.setNom(utilisateur.getNom());
            if (utilisateur.getPrenom() != null) utilisateur1.setPrenom(utilisateur.getPrenom());
            if (utilisateur.getEmail() != null) utilisateur1.setEmail(utilisateur.getEmail());
            if (utilisateur.getDate_naissance()!=null)utilisateur1.setDate_naissance(utilisateur.getDate_naissance());
            if (utilisateur.getMdp() != null) utilisateur1.setMdp(utilisateur.getEmail());
            return utilisateurRepositiry.save(utilisateur1);
        }
        return null;
    }

    @PostMapping("/authentification")
    public Utilisateur authentification(@RequestBody Utilisateur user, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        Utilisateur utilisateur = findByEmail(user.getEmail());
        if(utilisateur!=null){
            if(utilisateur.getMdp().equals(user.getMdp())) {
                Utilisateur utilisateurRetour = utilisateur;
                utilisateurRetour.setMdp("");
                return utilisateurRetour;
            }
            response.setStatus(403);
            response.getWriter().write("mot de passe incorrect");
            response.getWriter().close();

            return null;
        }
        response.setStatus(403);
        response.getWriter().write("email inconnu");
        response.getWriter().close();
        return null;
    }


    private Utilisateur findByEmail(String email){
        Iterable<Utilisateur> allUsers = utilisateurRepositiry.findAll();
        for (Utilisateur user:allUsers) {
            if(user.getEmail().equals(email)) return user;
        }
        return null;
    }

}