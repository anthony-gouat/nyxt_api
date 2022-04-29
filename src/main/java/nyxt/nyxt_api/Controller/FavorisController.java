package nyxt.nyxt_api.Controller;

import nyxt.nyxt_api.Repository.FavorisRepository;
import nyxt.nyxt_api.Tables.Favoris;
import nyxt.nyxt_api.Tables.FavorisId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favoris")
public class FavorisController {

    @Autowired
    private FavorisRepository favorisRepository;

    @GetMapping
    public List<Favoris> findAllFavoris() {
        return (List<Favoris>) favorisRepository.findAll();
    }

    @GetMapping("/{id_produit}/{id_util}")
    public ResponseEntity<Favoris> findFavorisById(@PathVariable(value = "id_produit") long id_produit, @PathVariable(value = "id_util") long id_util) {
        FavorisId id = new FavorisId(id_produit,id_util);
        Optional<Favoris> favoris = favorisRepository.findById(id);

        if(favoris.isPresent()) {
            return ResponseEntity.ok().body(favoris.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id_util}")
    public List<Favoris> findFavorisById(@PathVariable(value = "id_util") long id_util) {
        List<Favoris> list = (List<Favoris>) favorisRepository.findAll();
        ArrayList<Favoris> listByIdRecette = new ArrayList<Favoris>();
        for (Favoris favoris : list) {
            if(favoris.getId_util()==id_util)listByIdRecette.add(favoris);
        }
        return listByIdRecette;
    }

    @PostMapping
    public Favoris saveFavoris(@Validated @RequestBody Favoris favoris) {
        return favorisRepository.save(favoris);
    }

    @DeleteMapping("/{id_produit}/{id_util}")
    public void deleteFavoris(@PathVariable(value = "id_produit") long id_produit, @PathVariable(value = "id_util") long id_util){
        FavorisId id = new FavorisId(id_produit,id_util);
        favorisRepository.deleteById(id);
    }
}
