package com.vaib.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaib.demo.beans.PersonAddress;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Integer> {
    // Additional custom query methods can be added here if needed
}
