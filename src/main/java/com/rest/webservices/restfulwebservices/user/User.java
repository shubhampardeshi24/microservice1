package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	//@JsonProperty("User_Name")
	private String name;
	
	@Past(message = "Date of birth should be in the past always")
	//@JsonProperty("Date_Of_Birth")
	private LocalDate birthDate;
	
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;


	public User(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Past(message = "Date of birth should be in the past always") LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
}
