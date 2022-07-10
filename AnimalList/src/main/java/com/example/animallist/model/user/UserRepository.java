package com.example.animallist.model.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT id FROM users WHERE login =:login", nativeQuery = true)
    Integer findIdByLogin(String login);

    @Query(value = "SELECT password FROM users WHERE login =:login", nativeQuery = true)
    String findPasswordByLogin(String login);

    @Query(value = "SELECT * FROM users WHERE login =:login", nativeQuery = true)
    Optional <User> findByLogin(String login);
}
