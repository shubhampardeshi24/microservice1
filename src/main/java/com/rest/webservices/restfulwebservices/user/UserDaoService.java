package com.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	//JPa/Hibernate > Database
	//userdaoservice > static list
	
	//findall
	//save
	//findone
	
	
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "Shubham", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Adarsh", LocalDate.now().minusYears(25)));
		users.add(new User(1, "Shubham", LocalDate.now().minusYears(30)));
		users.add(new User(1, "Shubham", LocalDate.now().minusYears(30)));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	
	/*
 	public User findOne(int id) {
	Predicate<? super User> predicate = user -> user.getId().equals(id); 
	return users.stream().filter(predicate).findFirst().get();
}
	*/
}
