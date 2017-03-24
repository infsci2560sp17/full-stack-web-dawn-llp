package edu.infsci2560.repositories;

import edu.infsci2560.models.LipicUsers;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<LipicUsers, Long> {
    
    //
    
}
