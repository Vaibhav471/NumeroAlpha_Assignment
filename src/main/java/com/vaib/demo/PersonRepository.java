package com.vaib.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaib.demo.beans.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Additional custom query methods can be added here if needed
}
