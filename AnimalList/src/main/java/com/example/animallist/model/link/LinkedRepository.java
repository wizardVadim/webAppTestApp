package com.example.animallist.model.link;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedRepository extends CrudRepository<Link, Integer> {

    @Query(value = "SELECT id FROM links WHERE animal_id=:animalId", nativeQuery = true)
    Integer findByAnimalId(int animalId);
}
