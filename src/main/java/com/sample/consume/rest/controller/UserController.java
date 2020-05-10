package com.sample.consume.rest.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sample.consume.rest.model.UserResponse;
import com.sample.consume.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
		
	@GetMapping(value= "/rest/template/users/{pageNo}",  produces = { "application/json", "application/xml" })
	public UserResponse getUsersFromRest(@PathVariable("pageNo") String pageNo) throws JsonGenerationException, JsonMappingException, IOException {
		/*
		 	JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller m = context.createMarshaller();
			m.marshal(creditCard, new File("/employee.json"));
			
			// https://attacomsian.com/blog/processing-json-spring-boot
			
			// Spring Boot JSON : how to serve JSON data in a Spring Boot annotation.
			 // http://zetcode.com/springboot/json/
			   
			//Processing JSON Data in Spring Boot ## https://attacomsian.com/blog/processing-json-spring-boot
		 */
		
		
		
		return userService.getUserList(pageNo);
	}
	
	
}
