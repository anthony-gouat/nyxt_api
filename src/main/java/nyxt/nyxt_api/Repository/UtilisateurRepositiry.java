package nyxt.nyxt_api.Repository;

import nyxt.nyxt_api.Tables.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepositiry extends CrudRepository<Utilisateur, Long> { }
