package nyxt.nyxt_api.Repository;

import nyxt.nyxt_api.Tables.Commentaires;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentairesRepositiry extends CrudRepository<Commentaires, Long> { }
