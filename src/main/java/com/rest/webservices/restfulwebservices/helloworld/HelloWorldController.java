package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
	@Autowired
	private MessageSource messageSource;
	
	
	
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
	
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldinternationalized() {
		return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
	}


}
