package com.vaib.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaib.demo.beans.PersonAddress;

import java.util.List;
import java.util.Optional;

@Service
public class PersonAddressService {

    @Autowired
    private PersonAddressRepository personAddressRepository;

    // Retrieve all PersonAddress entities
    public List<PersonAddress> getAllAddresses() {
        return personAddressRepository.findAll();
    }

    // Retrieve a PersonAddress by its ID
    public Optional<PersonAddress> getAddressById(Integer id) {
        return personAddressRepository.findById(id);
    }

    // Save or update a PersonAddress entity
    public PersonAddress saveAddress(PersonAddress personAddress) {
        return personAddressRepository.save(personAddress);
    }

    // Delete a PersonAddress entity by its ID
    public void deleteAddressById(Integer id) {
        personAddressRepository.deleteById(id);
    }
    
    // Update a PersonAddress by ID (if exists)
    public PersonAddress updateAddress(Integer id, PersonAddress updatedAddress) {
        Optional<PersonAddress> existingAddress = personAddressRepository.findById(id);
        if (existingAddress.isPresent()) {
            PersonAddress address = existingAddress.get();
            address.setStreet(updatedAddress.getStreet());
            address.setState(updatedAddress.getState());
            return personAddressRepository.save(address);
        } else {
        	
        	return existingAddress.get();
        }
    }
}
