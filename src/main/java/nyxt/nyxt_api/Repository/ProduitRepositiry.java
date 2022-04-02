package nyxt.nyxt_api.Repository;

import nyxt.nyxt_api.Tables.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepositiry extends CrudRepository<Produit, Long> { }
