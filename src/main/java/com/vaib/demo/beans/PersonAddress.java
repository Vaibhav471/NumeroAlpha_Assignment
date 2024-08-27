package com.vaib.demo.beans;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class PersonAddress {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

   
    @Column(nullable = false)
    private String street;

    
    @Column(nullable = false)
    private String state;


	public PersonAddress(Integer addressId, String street, String state) {
		this.addressId = addressId;
		this.street = street;
		this.state = state;
	}


	public PersonAddress() {

	}


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

    
	
}
