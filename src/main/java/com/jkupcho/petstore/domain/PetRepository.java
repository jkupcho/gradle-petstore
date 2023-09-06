package com.jkupcho.petstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetRepository extends CrudRepository<Pet, Long>, PagingAndSortingRepository<Pet, Long> {

}
