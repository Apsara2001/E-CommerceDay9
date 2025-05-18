package lk.ac.vau.fas.ict.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	private String name;
	private int age;
	private String gender;
	
}
