package com.myshop.online.repository;


import com.myshop.online.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findAllById(int id);
    Person findByName(String name);

}