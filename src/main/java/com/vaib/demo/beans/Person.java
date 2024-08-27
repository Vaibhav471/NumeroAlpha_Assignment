package com.vaib.demo.beans;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    
    
    @Column(nullable = false)
    private String name;

    
    @Column(nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private PersonAddress personAddress;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public PersonAddress getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(PersonAddress personAddress) {
		this.personAddress = personAddress;
	}

	public Person(Integer personId, String name, Integer age, PersonAddress personAddress) {
		this.personId = personId;
		this.name = name;
		this.age = age;
		this.personAddress = personAddress;
	}

	public Person() {

       }
    
    
    
    
    
}
