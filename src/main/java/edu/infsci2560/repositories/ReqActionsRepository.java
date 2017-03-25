package edu.infsci2560.repositories;

import edu.infsci2560.models.LipicReqActions;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReqActionsRepository extends CrudRepository<LipicReqActions, Long> {
    
    List<LipicReqActions> findByOwnerId(Long ownerId);
}