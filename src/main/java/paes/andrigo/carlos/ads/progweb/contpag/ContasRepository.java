package paes.andrigo.carlos.ads.progweb.contpag;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContasRepository extends CrudRepository<Contas, Long> {
    
    List<Contas> findAll();
}
