package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService daoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return daoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUSer(@PathVariable Integer id) {
		User user = daoService.findById(id);
		if(user==null) {
			throw new UserNotFoundException("User Not found with UserID "+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUser());
		entityModel.add(link.withRel("all-sers"));
		return entityModel;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		
		if(!daoService.deleteById(id)) {
			throw new UserNotFoundException("User Not found with UserID "+id);
		}
	}
}


//entitymodel
//wbmvcl
