/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.repositories;

import edu.infsci2560.models.LipicUsersPictures;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author lili8
 */
public interface UsersPicturesRepository extends PagingAndSortingRepository<LipicUsersPictures, Long> {}