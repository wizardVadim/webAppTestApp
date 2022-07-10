package com.example.animallist.model.link;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedRepository extends CrudRepository<Link, Integer> {
}
