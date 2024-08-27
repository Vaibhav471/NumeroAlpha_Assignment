package com.vaib.demo;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaib.demo.beans.Person;




@RestController
@RequestMapping("/api/person")
public class MyController {
	@GetMapping("/")
	public String index() {
		return "Index index";
	}
	
	@Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.savePerson(person);
        return ResponseEntity.ok(createdPerson);


    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer personId) {
        Optional<Person> personOptional = personService.getPersonById(personId);
        return personOptional.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable Integer personId) {
        Optional<Person> personOptional = personService.getPersonById(personId);
        if (personOptional.isPresent()) {
            personService.deletePerson(personId);
            return ResponseEntity.ok("Person with ID " + personId + " was successfully deleted.");
        } else {
            return ResponseEntity.status(404).body("Person with ID " + personId + " not found.");
        }
    }
}
