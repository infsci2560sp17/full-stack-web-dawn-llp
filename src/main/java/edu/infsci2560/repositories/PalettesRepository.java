package edu.infsci2560.repositories;

import edu.infsci2560.models.LipicPalettes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PalettesRepository extends PagingAndSortingRepository<LipicPalettes, Long> {}
    
