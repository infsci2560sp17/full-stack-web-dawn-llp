package edu.infsci2560.repositories;

import edu.infsci2560.models.LipicUsers;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsersRepository extends CrudRepository<LipicUsers, Long> {
    
    List<LipicUsers> findByName(String name);
    
}
