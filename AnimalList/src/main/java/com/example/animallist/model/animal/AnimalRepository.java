package com.example.animallist.model.animal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    @Query(value = "SELECT animal_id FROM links WHERE user_id = :userId", nativeQuery = true)
    List<Integer> getAllIdByUserId(int userId);
}
