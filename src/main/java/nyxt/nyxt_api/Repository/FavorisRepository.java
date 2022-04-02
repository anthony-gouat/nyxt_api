package nyxt.nyxt_api.Repository;

import nyxt.nyxt_api.Tables.Favoris;
import nyxt.nyxt_api.Tables.FavorisId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorisRepository extends CrudRepository<Favoris, FavorisId> { }
