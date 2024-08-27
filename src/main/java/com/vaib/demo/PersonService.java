package com.vaib.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vaib.demo.beans.Person;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonAddressRepository personAddressRepository;
    
    private static final Logger log=org.slf4j.LoggerFactory.getLogger(PersonService.class);

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Integer id) {
    	try {
    		log.info("person with id {}",id);
            return personRepository.findById(id);

    	}
    	catch(Exception e) {
    		log.error("No person with id {} found",id);
            throw new PersonNotFoundException("Person with ID " + id + " not found");

    	}

    }

    public Person savePerson(Person person) {
        log.info("person saved with name {}", person.getName());
        return personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        try {
            log.info("person with id {} deleted", id);
            personRepository.deleteById(id);

    	}
    	catch(Exception e) {
    		log.error("No person with id {} found",id);
            throw new PersonNotFoundException("Person with ID " + id + " not found");

    	}
    }
}
