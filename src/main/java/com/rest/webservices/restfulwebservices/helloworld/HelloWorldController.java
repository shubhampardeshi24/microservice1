package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RestAPI
@RestController
public class HelloWorldController {
	// /hello-world
	
	// "Hello-World"
	
	
	/*
	 * @RequestMapping(method = RequestMethod.GET,path = "/hello-world") public
	 * String helloWorld() { return "Hello World"; }
	 */
	
	
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello Shubham";
	}
	
	//How to return json
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldbean() {
		return new HelloWorldBean("Hello World");
	}
	
	//path variable
	//users/{id}/todos/{id} =?users/1/todos/201
	// /hello-world/path-variable/{name} => /hello-world/path-variable/shubham
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldbeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
		
		
	}


}
