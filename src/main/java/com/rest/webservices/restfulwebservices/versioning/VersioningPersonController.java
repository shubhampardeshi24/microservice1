package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
		@GetMapping("/v1/person")
		public Personv1 getFirstVersionOfPerson() {
			return new Personv1("Bob Charlie");
		}
		
		@GetMapping("/v2/person")
		public Personv2 getSecondVersionOfPerson() {
			return new Personv2(new Name("Bob", "Charlie"));
		}
		
		@GetMapping(path = "/person", params = "version=1")
		public Personv1 getFirstVersionOfPersonRequestParameter() {
			return new Personv1("Bod Charlie");
			
		}
	
		@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
		public Personv2 getFirstVersionOfPersonRequestParam() {
			return new Personv2(new Name("Bob", "Charlie"));
		}
		
		
		@GetMapping(path = "/person/accept", produces =  "application/vnd.company.app-v1+json")
		public Personv1 getFirstVersionOfPersonRequestParameterAcceptHeader() {
			return new Personv1("Bod Charlie");
		}
		
		
		@GetMapping(path = "/person/accept", produces =  "application/vnd.company.app-v2+json")
		public Personv2 getSecondVersionOfPersonRequestParameterAcceptHeader() {
			return new Personv2(new Name("Bod", "Charlie"));
			
		}
	
}
