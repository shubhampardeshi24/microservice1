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
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "Shubham", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Adarsh", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Shubham", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Shubham", LocalDate.now().minusYears(30)));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	
	public boolean deleteById(int id) {
		boolean flag = false;
		if(users.removeIf(user->user.getId().equals(id))) {
			flag = true;
		}
		return flag;
	}
	/*
 	public User findOne(int id) {
	Predicate<? super User> predicate = user -> user.getId().equals(id); 
	return users.stream().filter(predicate).findFirst().get();
}
	*/
}
